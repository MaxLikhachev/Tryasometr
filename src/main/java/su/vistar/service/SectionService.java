package su.vistar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import su.vistar.entity.Section;
import su.vistar.repository.SectionRepository;

import java.util.List;
import java.util.Optional;


@Service
public class SectionService {
    @Autowired
    private SectionRepository sectionRepository;
    //@Override
    public Section add(Section section){return sectionRepository.save(section);}
    //@Override
    public Section getById(long id){
        Optional<Section> optionalCarSection = sectionRepository.findById(id);
        Section section = optionalCarSection.isPresent() ? optionalCarSection.get() : new Section();
        return section;
    }
    //@Override
    public List<Section> getAll(){return sectionRepository.findAll();}
    //@Override
    public Section edit(Section section){return sectionRepository.saveAndFlush(section);}
    //@Override
    public void delete(Section section) {sectionRepository.delete(section);}
    //@Override
    //public Section getByName(String name){return sectionRepository.getByName(name);}
}
