@Override
public void deactivateClassification(Long id) {
    DiversityClassification dc = repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Not found"));
    dc.setIsActive(false); // Fix: Use setIsActive
    repository.save(dc);
}