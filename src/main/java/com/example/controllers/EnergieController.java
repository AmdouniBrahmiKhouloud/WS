package com.example.controllers;

import com.example.jena.JenaEngine;
import org.apache.jena.rdf.model.Model;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/Transport")
public class EnergieController {
    /*http://localhost:8080/Transport/Energies*/
    @GetMapping("/Energies")
    public String getEnergies() throws ParseException, IOException {
        String NS = "";
        // lire le model a partir d'une ontologie
        Model model = JenaEngine.readModel("data/Ws_Transport.owl");

        if (model != null) {
            //lire le Namespace de l’ontologie
            NS = model.getNsPrefixURI("");

            // apply our rules on the owlInferencedModel
            Model inferedModel = JenaEngine.readInferencedModelFromRuleFile(model, "data/rules.txt");
            String q ="PREFIX ns: <http://www.semanticweb.org/khouloud/ontologies/2022/9/WS_Transport#>\n" +
                    "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                    "SELECT ?energie ?typeEnergie\n" +
                    "WHERE {\n" +
                    "?energie rdf:type ns:Energie .\n" +
                    "?energie ns:typeEnergie ?typeEnergie .\n" +
                    "}";
            String jsonString = JenaEngine.executeQuery(inferedModel,q);
            return jsonString ;
        }
        return null;
    }
    /*http://localhost:8080/Transport/Energies/Carburant*/
    @GetMapping("/Energies/Carburant")
    public String getEnergiesCarburant() throws ParseException, IOException {
        String NS = "";
        // lire le model a partir d'une ontologie
        Model model = JenaEngine.readModel("data/Ws_Transport.owl");

        if (model != null) {
            //lire le Namespace de l’ontologie
            NS = model.getNsPrefixURI("");

            // apply our rules on the owlInferencedModel
            Model inferedModel = JenaEngine.readInferencedModelFromRuleFile(model, "data/rules.txt");
            String q ="PREFIX ns: <http://www.semanticweb.org/khouloud/ontologies/2022/9/WS_Transport#>\n" +
                    "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                    "SELECT ?energie ?typeEnergie\n" +
                    "WHERE {\n" +
                    "?energie rdf:type ns:Carburant .\n" +
                    "?energie ns:typeEnergie ?typeEnergie .\n" +
                    "}";
            String jsonString = JenaEngine.executeQuery(inferedModel,q);
            return jsonString ;
        }
        return null;
    }
    /*http://localhost:8080/Transport/Energies/Carburant*/
    @GetMapping("/Energies/Electrique")
    public String getEnergiesElectrique() throws ParseException, IOException {
        String NS = "";
        // lire le model a partir d'une ontologie
        Model model = JenaEngine.readModel("data/Ws_Transport.owl");

        if (model != null) {
            //lire le Namespace de l’ontologie
            NS = model.getNsPrefixURI("");

            // apply our rules on the owlInferencedModel
            Model inferedModel = JenaEngine.readInferencedModelFromRuleFile(model, "data/rules.txt");
            String q ="PREFIX ns: <http://www.semanticweb.org/khouloud/ontologies/2022/9/WS_Transport#>\n" +
                    "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                    "SELECT ?energie ?typeEnergie\n" +
                    "WHERE {\n" +
                    "?energie rdf:type ns:Electrique .\n" +
                    "?energie ns:typeEnergie ?typeEnergie .\n" +
                    "}";
            String jsonString = JenaEngine.executeQuery(inferedModel,q);
            return jsonString ;
        }
        return null;
    }
}
