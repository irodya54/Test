import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import ru.radion.entity.DataRequest;
import ru.radion.repository.DataRepository;
import ru.radion.repository.DataRepositoryImpl;
import ru.radion.service.DataService;
import ru.radion.service.DataServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class ServiceTest {

    private static final DataRepository repositoryMock = Mockito.mock(DataRepositoryImpl.class);
    private DataService dataService;


    @Test
    void getByIdWithWhenTest() {
        Optional<DataRequest> request = Optional.of(new DataRequest(1L, "Test", 30));
        Mockito.when(repositoryMock.getDataById(1L)).thenReturn(request);
        dataService = new DataServiceImpl(repositoryMock);

        Optional<DataRequest> mayBeData = dataService.getDataById(1L);

        assertTrue(mayBeData.isPresent());
        assertTrue(mayBeData.get().getId().equals(1L)
                || mayBeData.get().getName().equals("Test")
                || mayBeData.get().getAge().equals(30));

    }

    @Test
    void getByIdWithDo () {
        Optional<DataRequest> request = Optional.of(new DataRequest(1L, "Test", 30));
        Mockito.doReturn(request).when(repositoryMock).getDataById(1L);

        dataService = new DataServiceImpl(repositoryMock);

        Optional<DataRequest> mayBeData = dataService.getDataById(1L);

        assertTrue(mayBeData.isPresent());
        assertTrue(mayBeData.get().getId().equals(1L)
                || mayBeData.get().getName().equals("Test")
                || mayBeData.get().getAge().equals(30));
    }

    @Test
    void getDataByListIdTest() {
        List<DataRequest> testListRequests = new ArrayList<>();
        DataRequest requestRadion = new DataRequest(1l, "Radion", 31);
        testListRequests.add(requestRadion);
        DataRequest requestOlya = new DataRequest(2l, "Olya", 18);
        testListRequests.add(requestOlya);

        Mockito.when(repositoryMock.getDataByListId(Mockito
                                                .argThat(arg -> arg == null || arg.size() < 3)))
                .thenReturn(testListRequests);

        dataService = new DataServiceImpl(repositoryMock);

        List<Long> listId = new ArrayList<>();
        listId.add(1L);
        listId.add(2L);
        List<DataRequest> dataByListId = dataService.getDataByListId(listId);

        assertTrue(dataByListId.size() == 2);
        assertEquals(dataByListId.get(0), requestRadion);
        assertEquals(dataByListId.get(1), requestOlya);

    }

}
