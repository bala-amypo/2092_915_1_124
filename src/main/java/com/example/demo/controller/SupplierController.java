@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

    private final SupplierService service;

    public SupplierController(SupplierService service) {
        this.service = service;
    }

    @PostMapping
    public Supplier create(@RequestBody Supplier s) {
        return service.createSupplier(s);
    }

    @GetMapping
    public List<Supplier> all() {
        return service.getAllSuppliers();
    }

    @PutMapping("/{id}/deactivate")
    public Supplier deactivate(@PathVariable Long id) {
        return service.deactivateSupplier(id);
    }
}
