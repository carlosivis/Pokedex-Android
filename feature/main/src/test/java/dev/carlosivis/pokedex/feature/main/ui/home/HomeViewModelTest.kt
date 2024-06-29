import dev.carlosivis.pokedex.domain.pokemon.model.PokemonPage
import dev.carlosivis.pokedex.domain.pokemon.model.PokemonPageDomain
import dev.carlosivis.pokedex.domain.pokemon.usecase.GetPokemonsPageUseCase
import dev.carlosivis.pokedex.feature.main.model.PokemonModel
import dev.carlosivis.pokedex.feature.main.ui.home.*
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module

@OptIn(ExperimentalCoroutinesApi::class)
internal class HomeViewModelTest {

    private lateinit var viewModel: HomeViewModel
    private lateinit var action: (HomeViewAction) -> Unit
    private val navigation: HomeNavigation = mockk()
    private val getPokemonsPageUseCase: GetPokemonsPageUseCase = mockk()
    private val homeModule = module {
        single { getPokemonsPageUseCase }
    }

    @Before
    fun setUp() {
        startKoin { modules(homeModule) }
        viewModel = HomeViewModel(navigation)
        action = viewModel::dispatchAction
    }

    @After
    fun tearDown() {
        stopKoin()
    }

    @Test
    fun `test dispatchAction with Navigate_Details`() {
        // GIVEN
        navigationStub()

        // WHEN
        action(HomeViewAction.Navigate.Details("1"))

        // THEN
        verify(exactly = 1) { navigation.navigateToDetails("1") }
    }

    @Test
    fun `test dispatchAction with Get_Page_First success`() = runTest {
        // GIVEN
        useCasePageSuccessStub()

        // WHEN
        action(HomeViewAction.Get.Page.First)

        // THEN
        verify(exactly = 1) { getPokemonsPageUseCase(any(), any(), any()) }

        val pokemons = viewModel.state.value.pokemons

        assert(pokemons.isNotEmpty())
        assert(pokemons[0].name == PokemonModel.mock.name)
    }

    @Test
    fun `test dispatchAction with Get_Page_Next success`() = runTest {
        // GIVEN
        useCasePageSuccessStub()

        // WHEN
        action(HomeViewAction.Get.Page.Next)

        // THEN
        verify(exactly = 1) { getPokemonsPageUseCase(any(), any(), any()) }

        val pokemons = viewModel.state.value.pokemons

        assert(pokemons.isNotEmpty())
        assert(pokemons[0].name == PokemonModel.mock.name)
    }

    @Test
    fun `test dispatchAction with Get_Page_First failure`() = runTest {
        // GIVEN
        useCaseFailureStub()

        // WHEN
        action(HomeViewAction.Get.Page.First)

        // THEN
        verify(exactly = 1) { getPokemonsPageUseCase(any(), any(), any()) }

        assert(viewModel.state.value.error != null)
    }

    private fun navigationStub() {
        every { navigation.navigateToDetails(any()) } returns Unit
    }

    private fun useCasePageSuccessStub() {
        every {
            getPokemonsPageUseCase(
                params = any(),
                onSuccess = captureLambda(),
                onFailure = any()
            )
        } answers {
            lambda<(PokemonPageDomain) -> Unit>().invoke(PokemonPageDomain.mock)
        }
    }

    private fun useCaseFailureStub() {
        every {
            getPokemonsPageUseCase(
                params = any(),
                onSuccess = any(),
                onFailure = captureLambda()
            )
        } answers {
            lambda<(Throwable) -> Unit>().invoke(Throwable())
        }
    }
}
