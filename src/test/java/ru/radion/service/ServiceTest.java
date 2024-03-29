<<<<<<< HEAD:src/test/java/ru/radion/service/ServiceTest.java
package ru.radion.service;

import org.junit.jupiter.api.BeforeEach;
=======
>>>>>>> 6e523f4 (add method and two branches):src/test/java/ServiceTest.java
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import ru.radion.entity.DataRequest;
import ru.radion.repository.DataRepository;
import ru.radion.repository.DataRepositoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ServiceTest {
<<<<<<< HEAD:src/test/java/ru/radion/service/ServiceTest.java

    @InjectMocks
    private DataRepository repositoryMock = Mockito.mock(DataRepositoryImpl.class);

    @Mock
    private DataService dataService;
=======
    @Mock
    private static final DataRepository repositoryMock = Mockito.mock(DataRepositoryImpl.class);

    @InjectMocks
    private DataService dataService = new DataServiceImpl(repositoryMock);
>>>>>>> 6e523f4 (add method and two branches):src/test/java/ServiceTest.java

    @BeforeEach
    void prepare() {
        dataService = new DataServiceImpl(repositoryMock);
    }


    @Test
    void getByIdWithWhenTest() {
        Optional<DataRequest> request = Optional.of(new DataRequest(1L, "Test", 30));
        Mockito.when(repositoryMock.getDataById(1L)).thenReturn(request);

        Optional<DataRequest> mayBeData = dataService.getDataById(1L);
        assertAll(
                () -> assertTrue(mayBeData.isPresent(), "Объект пустой"),
                () -> assertTrue(mayBeData.get().getId().equals(1L)
                        && mayBeData.get().getName().equals("Test")
                        && mayBeData.get().getAge().equals(30), "Объекты не равны"));
    }

    @Test
    void getByIdWithDo() {
        Optional<DataRequest> request = Optional.of(new DataRequest(1L, "Test", 30));
        Mockito.doReturn(request).when(repositoryMock).getDataById(1L);

        Optional<DataRequest> mayBeData = dataService.getDataById(1L);

        assertTrue(mayBeData.isPresent());
        assertTrue(mayBeData.get().getId().equals(1L)
                && mayBeData.get().getName().equals("Test")
                && mayBeData.get().getAge().equals(30));
    }

    @Test
    void getDataByListIdTest() {
        List<DataRequest> testListRequests = new ArrayList<>();

        DataRequest requestRadion = new DataRequest(1l, "Radion", 31);
        DataRequest requestOlya = new DataRequest(2l, "Olya", 18);

        testListRequests.add(requestRadion);
        testListRequests.add(requestOlya);

        Mockito.when(repositoryMock.getDataByListId(Mockito
                        .argThat(arg -> arg == null || arg.size() < 3)))
                .thenReturn(testListRequests);

<<<<<<< HEAD:src/test/java/ru/radion/service/ServiceTest.java

=======
>>>>>>> 6e523f4 (add method and two branches):src/test/java/ServiceTest.java
        List<Long> listId = new ArrayList<>();
        listId.add(1L);
        listId.add(2L);
        List<DataRequest> dataByListId = dataService.getDataByListId(listId);

        assertTrue(dataByListId.size() == 2);
        assertEquals(dataByListId.get(0), requestRadion);
        assertEquals(dataByListId.get(1), requestOlya);
<<<<<<< HEAD:src/test/java/ru/radion/service/ServiceTest.java
=======
    }

    @Test
    void getDataByUsernameTest() {
        Optional<DataRequest> requestRadion = Optional.of(new DataRequest(1L, "Radion", 31));
        Mockito.when(repositoryMock.getDataByName(Mockito.any())).thenReturn(requestRadion);
        Optional<DataRequest> mayBeRadion = dataService.getDataByName("Radion");

        assertTrue(mayBeRadion.isPresent());
        assertEquals(mayBeRadion, requestRadion);
>>>>>>> 6e523f4 (add method and two branches):src/test/java/ServiceTest.java
    }
}
