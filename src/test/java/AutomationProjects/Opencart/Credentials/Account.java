package AutomationProjects.Opencart.Credentials;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Account {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    @Builder.Default
    private String password = "Test@1234";
}

