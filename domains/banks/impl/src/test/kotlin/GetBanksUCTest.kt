import com.pagatodo.test.api.models.BanksUIStates
import com.pagatodo.test.api.repository.BanksRepository
import com.pagatodo.test.impl.usecases.GetBanksUCImpl
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class GetBanksUCTest {

    @MockK
    lateinit var repository: BanksRepository

    @MockK
    lateinit var errorAction: BanksUIStates.Error

    @MockK
    lateinit var successAction: BanksUIStates.Success

    lateinit var useCase: GetBanksUCImpl

    @Before
    fun setup() {
        Dispatchers.setMain(StandardTestDispatcher())
        MockKAnnotations.init(this, relaxed = true, relaxUnitFun = true)
        useCase = GetBanksUCImpl(repository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun invokingUCRetrievesBanksReturnLoading() = runTest {
        coEvery { repository.getBanks() } returns flow { emit(errorAction) }
        assert(useCase.invoke().first() is BanksUIStates.Loading)
    }

    @Test
    fun invokingUCRetrievesProductDetailReturnAnError() = runTest {
        coEvery { repository.getBanks() } returns flow { throw RuntimeException("Crash!") }
        assert(useCase.invoke().last() is BanksUIStates.Error)
    }

    @Test
    fun invokingUCRetrievesProductDetailReturnSuccess() = runTest {
        coEvery { repository.getBanks() } returns flow { emit(successAction) }
        assert(useCase.invoke().last() is BanksUIStates.Success)
    }

}
