@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserAccountService service;

    public AuthController(UserAccountService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public UserAccount register(@RequestBody UserAccount user) {
        return service.register(user);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest req) {
        return new AuthResponse(service.login(req.getEmail(), req.getPassword()));
    }
}
