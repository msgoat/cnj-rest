package group.msg.at.cloud.cloudtrain.adapter.rest.downstream;

import java.util.List;

public interface GrantedPermissionsClient {

    List<GrantedPermission> getGrantedPermissionsByCurrentUser();

}
