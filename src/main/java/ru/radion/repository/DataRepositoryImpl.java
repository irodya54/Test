package ru.radion.repository;

import ru.radion.entity.DataRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DataRepositoryImpl implements ru.radion.repository.DataRepository {
    private static final List<DataRequest> REQUEST_LIST = new ArrayList<>();

    static {
        REQUEST_LIST.add(new DataRequest(1L, "Radion", 31));
    }


    @Override
    public Optional<DataRequest> getDataById(Long id) {
        return REQUEST_LIST.stream().filter(dataRequest -> dataRequest.getId().equals(id)).findFirst();
    }

    @Override
    public List<DataRequest> getDataByListId(List<Long> idList) {
        List<DataRequest> dataRequests = new ArrayList<>();
        for (Long id : idList) {
            Optional<DataRequest> first = REQUEST_LIST.stream()
                    .filter(dataRequest -> id.equals(dataRequest.getId()))
                    .findFirst();
            first.ifPresent(dataRequests::add);
        }
        return dataRequests;
    }

    @Override
    public void saveData(DataRequest data) {
        REQUEST_LIST.add(data);
    }
}
