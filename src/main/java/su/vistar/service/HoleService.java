package su.vistar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import su.vistar.entity.Hole;
import su.vistar.repository.HoleRepository;

import java.util.List;
import java.util.Optional;


@Service
public class HoleService {
    @Autowired
    private HoleRepository holeRepository;
    //@Override
    public Hole add(Hole hole){return holeRepository.save(hole);}
    //@Override
    public Hole getById(long id){
        Optional<Hole> optionalCarHole = holeRepository.findById(id);
        Hole hole = optionalCarHole.isPresent() ? optionalCarHole.get() : new Hole();
        return hole;
    }
    //@Override
    public List<Hole> getAll(){return holeRepository.findAll();}
    //@Override
    public Hole edit(Hole hole){return holeRepository.saveAndFlush(hole);}
    //@Override
    public void delete(Hole hole) {holeRepository.delete(hole);}
    //@Override
    //public Hole getByName(String name){return holeRepository.getByName(name);}
}
