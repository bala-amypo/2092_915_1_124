@Entity
@Data // Or use @Getter/@Setter
public class DiversityTarget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer targetYear;
    private Boolean active = true; // Ensure this is 'active'
    // ... other fields
}