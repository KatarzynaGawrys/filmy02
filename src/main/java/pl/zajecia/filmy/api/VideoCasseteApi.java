package pl.zajecia.filmy.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.zajecia.filmy.dao.entity.VideoCassette;
import pl.zajecia.filmy.manager.VideoCassetteManager;

import java.util.Optional;

@RestController
@RequestMapping("/api/cassetts")
public class VideoCasseteApi {

    private VideoCassetteManager videoCassetes;

    @Autowired
    public VideoCasseteApi(VideoCassetteManager videoCassetes) {
        this.videoCassetes = videoCassetes;
    }

    @GetMapping("/all")
    public Iterable<VideoCassette> getAll() {
        return videoCassetes.findAll();
    }

    @GetMapping
    public Optional<VideoCassette> getById(@RequestParam long index) {
        return videoCassetes.findAllById(index);
    }

    @PostMapping
    public VideoCassette addVideo(@RequestBody VideoCassette videoCassette) {
        return videoCassetes.save(videoCassette);
    }

    @PutMapping
    public VideoCassette updateVideo(@RequestBody VideoCassette videoCassette) {
        return videoCassetes.save(videoCassette);
    }

    @DeleteMapping
    public void deleteVideo(@RequestParam long index) {
        videoCassetes.delete(index);
    }
}
