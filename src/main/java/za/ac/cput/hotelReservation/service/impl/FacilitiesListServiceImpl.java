package za.ac.cput.hotelReservation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.hotelReservation.domain.FacilitiesList;
import za.ac.cput.hotelReservation.repository.FacilitiesListRepo;
import za.ac.cput.hotelReservation.service.FacilitiesListService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2016/06/20.
 */
@Service
public class FacilitiesListServiceImpl implements FacilitiesListService
{
    @Autowired
    FacilitiesListRepo repository;

    @Override
    public FacilitiesList findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public FacilitiesList save(FacilitiesList entity) {
        return repository.save(entity);
    }

    @Override
    public FacilitiesList update(FacilitiesList entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(FacilitiesList entity) {
        repository.delete(entity);
    }

    @Override
    public List<FacilitiesList> findAll() {

        List<FacilitiesList> allFacilitiesList = new ArrayList<>();

        Iterable<FacilitiesList> facilitiesLists = repository.findAll();
        for(FacilitiesList facilitiesList : facilitiesLists)
        {
            allFacilitiesList.add(facilitiesList);
        }
        return allFacilitiesList;
    }
}
