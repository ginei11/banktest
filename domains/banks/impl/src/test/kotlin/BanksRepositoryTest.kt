import com.pagatodo.test.api.models.BankModel
import com.pagatodo.test.api.models.BanksUIStates
import com.pagatodo.test.api.repository.BanksRepository
import com.pagatodo.test.impl.infrastructure.BanksService
import com.pagatodo.test.impl.infrastructure.database.BankDao
import com.pagatodo.test.impl.infrastructure.database.BanksDatabase
import com.pagatodo.test.impl.infrastructure.database.BanksEntity
import com.pagatodo.test.impl.repositories.BanksRepositoryImpl
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import retrofit2.Response


@OptIn(ExperimentalCoroutinesApi::class)
class BanksRepositoryTest {

    @MockK
    lateinit var service: BanksService

    @MockK
    lateinit var database: BanksDatabase

    @MockK
    lateinit var bankDao: BankDao

    private lateinit var repository: BanksRepositoryImpl

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxed = true, relaxUnitFun = true)
        repository = BanksRepositoryImpl(
            service,
            database
        )
    }

    @Test
    fun invokingServiceProductDetailReturnSuccess() = runTest {
        val mockResponse = mockk<List<BankModel>>()
        coEvery { service.getBanks() } returns Response.success(
            200,
            mockResponse
        )

        every { bankDao.loadBanks() } returns emptyList()
        every { bankDao.loadBanks().size } returns 0
        coEvery { database.bankDao() } returns bankDao

        val result = repository.getBanks().first()
        assert(result is BanksUIStates.Success)
    }

    @Test
    fun invokingDataBaseProductDetailReturnSuccess() = runTest {
        val mockResponse = mockk<List<BankModel>>()
        coEvery { service.getBanks() } returns Response.success(
            200,
            mockResponse
        )
        val banksEntity = mockk<BanksEntity>()

        every { bankDao.loadBanks() } returns listOf(banksEntity)
        every { bankDao.loadBanks().size } returns 1
        coEvery { database.bankDao() } returns bankDao

        val result = repository.getBanks().first()
        assert(result is BanksUIStates.Success)
    }
}
