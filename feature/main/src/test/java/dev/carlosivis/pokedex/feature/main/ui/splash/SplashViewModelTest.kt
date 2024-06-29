import dev.carlosivis.pokedex.feature.main.ui.splash.SplashNavigation
import dev.carlosivis.pokedex.feature.main.ui.splash.SplashViewAction
import dev.carlosivis.pokedex.feature.main.ui.splash.SplashViewModel
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module

@ExperimentalCoroutinesApi
class SplashViewModelTest  {

    @RelaxedMockK
    private lateinit var navigation: SplashNavigation

    private lateinit var viewModel: SplashViewModel
    private val testDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(testDispatcher)
        startKoin {
            modules(
                module {
                    single { navigation }
                }
            )
        }
        viewModel = SplashViewModel(navigation)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        stopKoin()
    }

    @Test
    fun `dispatchAction Navigate_Home should navigate to home`() = runTest {
        // Given
        every { navigation.navigateToHome() } returns Unit

        // When
        viewModel.dispatchAction(SplashViewAction.Navigate.Home)

        // Then
        verify(exactly = 1) { navigation.navigateToHome() }
    }

}