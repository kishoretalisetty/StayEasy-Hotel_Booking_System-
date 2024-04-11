package org.example.RepositoryLayer;

import org.example.Entities.BookingRoomsMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookingRoomsMappingRepository extends JpaRepository<BookingRoomsMapping,Long> {

    Optional<BookingRoomsMapping> findByName(String userName);
}
