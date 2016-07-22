package za.ac.cput.hotelReservation.service;

import java.util.List;

/**
 * Created by student on 2016/06/20.
 */
public interface Services<S, ID>
{
    public S findById(ID id);
    public S save(S entity);
    public S update(S entity);
    public void delete(S entity);
    public List<S> findAll();
}
