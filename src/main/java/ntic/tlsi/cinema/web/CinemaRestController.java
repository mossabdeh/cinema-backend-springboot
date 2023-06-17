package ntic.tlsi.cinema.web;

import lombok.Data;
import ntic.tlsi.cinema.dao.FilmRepository;
import ntic.tlsi.cinema.dao.TicketRepository;
import ntic.tlsi.cinema.entities.Film;
import ntic.tlsi.cinema.entities.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class CinemaRestController {
    @Autowired
    private FilmRepository filmRepository ;
    @Autowired
    private TicketRepository ticketRepository;

  /*  @GetMapping("/listFilms")
    public List<Film> films(){
        return filmRepository.findAll();
    }*/
    @GetMapping(path = "/imageFilm/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] image(@PathVariable (name ="id") Long id) throws Exception{
        Film f = filmRepository.findById(id).get();
        String photoName = f.getPhoto();
        File file = new File(System.getProperty("user.home")+"/cinema/images/"+photoName);
        Path path = Paths.get(file.toURI());
        // Resize the image to 500x500 pixels using ImageMagick
        //ProcessBuilder pb = new ProcessBuilder("convert", file.getAbsolutePath(), "-resize", "585x412", path.toString());
        // Resize the image to 500x500 pixels using ImageMagick
       /* String[] cmd = {"convert", file.getAbsolutePath(), "-resize", "555x412", path.toString()};
        Process process = new ProcessBuilder(cmd).start();
        process.waitFor(); // Wait for the process to complete*/

        return Files.readAllBytes(path);

    }

    @PostMapping("/payerTickets")
    @Transactional
    public List<Ticket> payerTickets(@RequestBody  TicketForm ticketForm){
        List<Ticket> listTickets = new ArrayList<>() ;
     ticketForm.getTickets().forEach(idTicket ->{
         Ticket ticket = ticketRepository.findById(idTicket).get();
         ticket.setNomClient(ticketForm.getNomClient());
         ticket.setCodePayment(ticketForm.getCodePayment());
         ticket.setReserve(true);
         ticketRepository.save(ticket);
         listTickets.add(ticket);
     });
    return  listTickets;
    }}


    @Data
    class  TicketForm {
     private String nomClient ;
     private int codePayment;
     private List<Long> tickets = new ArrayList<>();


    }


