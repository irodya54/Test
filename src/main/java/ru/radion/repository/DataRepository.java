package ru.radion.repository;

import ru.radion.entity.DataRequest;

import java.util.List;
import java.util.Optional;

public interface DataRepository {

    Optional<DataRequest> getDataById(Long id);

    Optional<DataRequest> getDataByName(String username);

    List<DataRequest> getDataByListId(List<Long> id);

    void saveData (DataRequest data);

}
