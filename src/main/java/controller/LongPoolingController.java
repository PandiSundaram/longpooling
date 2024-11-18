package controller;

import model.DataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LongPoolingController {

    @Autowired
    DataModel dataModel;

    @GetMapping("/details")
    public String getData() throws InterruptedException {

        return dataModel.getData();
    }

    @GetMapping("/details/{data}")
    public Boolean setData(@PathVariable String data){

        return dataModel.addData(data);
    }



}
