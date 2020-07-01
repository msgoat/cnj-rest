package group.msg.at.cloud.cloudtrain.adapter.rest.downstream;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RegisterRestClient
@Path("api/v1/grantedPermissions")
public interface GrantedPermissionsClient {

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    List<GrantedPermission> getGrantedPermissionsByCurrentUser();
}
