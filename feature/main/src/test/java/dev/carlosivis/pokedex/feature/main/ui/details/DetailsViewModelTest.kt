import dev.carlosivis.pokedex.domain.pokemon.model.PokemonDomain
import dev.carlosivis.pokedex.domain.pokemon.usecase.GetPokemonUseCase
import dev.carlosivis.pokedex.feature.main.model.PokemonModel
import dev.carlosivis.pokedex.feature.main.ui.details.DetailsNavigation
import dev.carlosivis.pokedex.feature.main.ui.details.DetailsViewAction
import dev.carlosivis.pokedex.feature.main.ui.details.DetailsViewModel
import io.mockk.every
import io.mockk.invoke
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module

@OptIn(ExperimentalCoroutinesApi::class)
internal class DetailsViewModelTest {

    private lateinit var viewModel: DetailsViewModel
    private lateinit var action: (DetailsViewAction) -> Unit
    private val navigation: DetailsNavigation = mockk()
    private val getPokemonUseCase: GetPokemonUseCase = mockk()
    private val detailsModule = module { single { getPokemonUseCase } }

    @Before
    fun setUp() {
        startKoin { modules(detailsModule) }
        viewModel = DetailsViewModel(navigation)
        action = viewModel::dispatchAction
    }

    @After
    fun tearDown() {
        stopKoin()
    }

    @Test
    fun `test dispatchAction with Navigate_PopBackStack`() {
        // GIVEN
        navigationStub()

        // WHEN
        action(DetailsViewAction.Navigate.PopBackStack)

        // THEN
        verify(exactly = 1) { navigation.popBackStack() }
    }

    @Test
    fun `test dispatchAction with Set_Pokemon success`() = runTest {
        // GIVEN
        useCaseSuccessStub()

        // WHEN
        action(DetailsViewAction.Set.Pokemon(PokemonModel.mock.name))

        // THEN
        verify(exactly = 1) { getPokemonUseCase(any(), any(), any()) }

        val pokemon = viewModel.state.value.pokemon

        assert(pokemon != null)
        assert(pokemon?.id == PokemonModel.mock.id)
        assert(pokemon?.name == PokemonModel.mock.name)
        assert(pokemon?.height == PokemonModel.mock.height)
        assert(pokemon?.weight == PokemonModel.mock.weight)
    }

    @Test
    fun `test send null to dispatchAction with Set_Pokemon success`() = runTest {
        // WHEN
        action(DetailsViewAction.Set.Pokemon(null))

        // THEN
        assert(viewModel.state.value.pokemon == null)
    }

    @Test
    fun `test dispatchAction with Set_Pokemon failure`() = runTest {
        // GIVEN
        useCaseFailureStub()

        // WHEN
        action(DetailsViewAction.Set.Pokemon("1"))

        // THEN
        verify(exactly = 1) { getPokemonUseCase(any(), any(), any()) }

        assert(viewModel.state.value.pokemon == null)
    }

    @Test
    fun onCleared() {
        // GIVEN
        useCaseCanceledStub()

        // WHEN
        viewModel.onCleared()

        // THEN
        verify(exactly = 1) { getPokemonUseCase.cancel() }
    }

    private fun navigationStub() {
        every { navigation.popBackStack() } returns Unit
    }

    private fun useCaseSuccessStub() {
        every {
            getPokemonUseCase(
                params = any(),
                onSuccess = captureLambda(),
                onFailure = any()
            )
        } answers {
            lambda<(PokemonDomain) -> Unit>().invoke(PokemonDomain.mock)
        }
    }

    private fun useCaseFailureStub() {
        every {
            getPokemonUseCase(
                params = any(),
                onSuccess = any(),
                onFailure = captureLambda()
            )
        } answers {
            lambda<(Throwable) -> Unit>().invoke(Throwable())
        }
    }

    private fun useCaseCanceledStub() {
        every { getPokemonUseCase.cancel() } returns Unit
    }
}
