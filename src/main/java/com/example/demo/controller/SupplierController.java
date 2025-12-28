@RestController
@RequestMapping("/supplier")
public class SupplierController {

    private final SupplierService service;

    public SupplierController(SupplierService service) {
        this.service = service;
    }

    @PostMapping
    public Supplier create(@RequestBody Supplier supplier) {
        return service.create(supplier);
    }

    @GetMapping("/active")
    public List<Supplier> getActive() {
        return service.getActive();
    }

    @GetMapping
    public List<Supplier> getAll() {
        return service.getAll();
    }

    @PutMapping("/deactivate/{id}")
    public Supplier deactivate(@PathVariable Long id) {
        return service.deactivate(id);
    }
}
