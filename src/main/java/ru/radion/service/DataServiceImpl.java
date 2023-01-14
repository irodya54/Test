package ru.radion.service;

import ru.radion.entity.DataRequest;
import ru.radion.repository.DataRepository;

import java.util.List;
import java.util.Optional;

public class DataServiceImpl implements DataService{

    private final DataRepository repository;

    public DataServiceImpl(DataRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<DataRequest> getDataById(Long id) {
        return repository.getDataById(id);
    }

    @Override
    public List<DataRequest> getDataByListId(List<Long> id) {
        return repository.getDataByListId(id);
    }

    @Override
    public void saveData(DataRequest data) {
        repository.saveData(data);
    }
}
