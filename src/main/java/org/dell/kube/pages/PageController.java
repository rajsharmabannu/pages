package org.dell.kube.pages;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
@RestController
@RequestMapping("/pages")
public class PageController {
    private IPageRepository pageRepository;
    Logger logger =(Logger)LoggerFactory.getLogger(this.getClass());
    public PageController(IPageRepository pageRepository)
    {
        this.pageRepository = pageRepository;
    }
    @PostMapping
    public ResponseEntity<Page> create(@RequestBody Page page) {
        Page newPage= pageRepository.create(page);
        return new ResponseEntity<Page>(newPage, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Page> read(@PathVariable long id) {

        logger.info("READ-INFO:Fetching page with id = " + id);
        logger.debug("READ-DEBUG:Fetching page with id = " + id);

        Page page = pageRepository.read(id);
        if(page!=null)
            return new ResponseEntity<Page>(page, HttpStatus.OK);
        else {
            logger.error("READ-ERROR:Could not find page with id = " + id);
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Page>> list() {
        logger.info("READ-INFO:Fetching list of pages. ");
        logger.debug("READ-DEBUG:Fetching list of pages. ");
        List<Page> pages= pageRepository.list();
        if(pages != null)
            return new ResponseEntity<List<Page>>(pages, HttpStatus.OK);
        else {
            logger.error("READ-ERROR:Could not find list of pages. ");
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("{id}")
    public ResponseEntity<Page> update(@RequestBody Page page, @PathVariable long id) {

        logger.info("READ-INFO: Updating page with id = " + id);
        logger.debug("READ-DEBUG: Updating page with id = " + id);

        Page updatedPage= pageRepository.update(page,id);
        if(updatedPage!=null)
            return new ResponseEntity<Page>(updatedPage, HttpStatus.OK);
        else
            logger.error("READ-ERROR:Could not update page with id = " + id);
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable long id) {

        logger.info("READ-INFO: Deleting page with id = " + id);
        logger.debug("READ-DEBUG: Deleting page with id = " + id);

        pageRepository.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}