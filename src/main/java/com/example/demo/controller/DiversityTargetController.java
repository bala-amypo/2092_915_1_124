@RestController
@RequestMapping("/diversity-target")
public class DiversityTargetController {

    private final DiversityTargetService service;

    public DiversityTargetController(DiversityTargetService service) {
        this.service = service;
    }

    @PostMapping
    public DiversityTarget create(@RequestBody DiversityTarget target) {
        return service.create(target);
    }

    @GetMapping("/year/{year}")
    public List<DiversityTarget> getByYear(@PathVariable int year) {
        return service.getByYear(year);
    }

    @GetMapping
    public List<DiversityTarget> getAll() {
        return service.getAll();
    }

    @PutMapping("/deactivate/{id}")
    public DiversityTarget deactivate(@PathVariable Long id) {
        return service.deactivate(id);
    }
}
