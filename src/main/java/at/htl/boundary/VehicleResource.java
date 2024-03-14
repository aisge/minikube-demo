package at.htl.boundary;

import at.htl.entity.Vehicle;
import at.htl.repository.VehicleRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/api/vehicle")
public class VehicleResource {
    @Inject
    VehicleRepository vehicleRepository;

    @Consumes(MediaType.APPLICATION_JSON)
            // @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    @POST
    public Response saveVehicle(Vehicle vehicle) {
        this.vehicleRepository.persist(vehicle);
        return Response.ok().build();
    }

    @GET
    @Path("/{id}")
    public Vehicle getVehicle(@PathParam("id") long id) {
        return vehicleRepository.findById(id);
    }

    @GET
    public List<Vehicle> getList() {
        return vehicleRepository.listAll();
    }
}
