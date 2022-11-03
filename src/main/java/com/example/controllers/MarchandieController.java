package com.example.controllers;

import com.example.jena.JenaEngine;
import org.apache.jena.rdf.model.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/Transport")
public class MarchandieController {
    /*http://localhost:8080/Transport/Marchandies*/
    @GetMapping("/Marchandies")
    public String getMarchandies() {
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
                    "SELECT ?marchandies ?nomMarchandies ?typeMarchandies ?uniteMarchandies ?poidsMarchandies\n" +
                    "WHERE {\n" +
                    "?marchandies rdf:type ns:Marchandies .\n" +
                    "?marchandies ns:nomMarchandies ?nomMarchandies .\n" +
                    "?marchandies ns:typeMarchandies ?typeMarchandies .\n" +
                    "?marchandies ns:uniteMarchandies ?uniteMarchandies .\n" +
                    "?marchandies ns:poidsMarchandies ?poidsMarchandies .\n" +
                    "}";
            String jsonString = JenaEngine.executeQuery(inferedModel,q);
            return jsonString ;
        }
        return null;
    }

    @GetMapping("/Marchandies/poid")
    public String getMarchandiesPooids(){
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
                    "SELECT ?marchandies ?nomMarchandies ?typeMarchandies ?uniteMarchandies ?poidsMarchandies\n" +
                    "WHERE {\n" +
                    "?marchandies rdf:type ns:Marchandies .\n" +
                    "?marchandies ns:nomMarchandies ?nomMarchandies .\n" +
                    "?marchandies ns:typeMarchandies ?typeMarchandies .\n" +
                    "?marchandies ns:uniteMarchandies ?uniteMarchandies .\n" +
                    "?marchandies ns:poidsMarchandies ?poidsMarchandies .\n" +
                    "}ORDER BY (?poidsMarchandies)";
            String jsonString = JenaEngine.executeQuery(inferedModel,q);
            return jsonString ;
        }
        return null;
    }

    @GetMapping("/Marchandies/typefraiches")
    public String getMarchandiesTypeFraiches() {
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
                    "SELECT ?marchandies ?nomMarchandies ?typeMarchandies ?uniteMarchandies ?poidsMarchandies\n" +
                    "WHERE {\n" +
                    "?marchandies rdf:type ns:Marchandies .\n" +
                    "?marchandies ns:nomMarchandies ?nomMarchandies .\n" +
                    "?marchandies ns:typeMarchandies ?typeMarchandies .\n" +
                    "?marchandies ns:uniteMarchandies ?uniteMarchandies .\n" +
                    "?marchandies ns:poidsMarchandies ?poidsMarchandies .\n" +
                    "FILTER (?typeMarchandies = \"fraîches\") .\n" +
                    "}ORDER BY (?poidsMarchandies)";
            String jsonString = JenaEngine.executeQuery(inferedModel,q);
            return jsonString ;
        }
        return null;
    }

    @GetMapping("/Marchandies/typemetaux")
    public String getMarchandiestypemetaux() {
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
                    "SELECT ?marchandies ?nomMarchandies ?typeMarchandies ?uniteMarchandies ?poidsMarchandies\n" +
                    "WHERE {\n" +
                    "?marchandies rdf:type ns:Marchandies .\n" +
                    "?marchandies ns:nomMarchandies ?nomMarchandies .\n" +
                    "?marchandies ns:typeMarchandies ?typeMarchandies .\n" +
                    "?marchandies ns:uniteMarchandies ?uniteMarchandies .\n" +
                    "?marchandies ns:poidsMarchandies ?poidsMarchandies .\n" +

                    "FILTER (?typeMarchandies = \"métaux\") .\n" +
                    "}ORDER BY (?poidsMarchandies)";
            String jsonString = JenaEngine.executeQuery(inferedModel,q);
            return jsonString ;
        }
        return null;
    }

    @GetMapping("/Marchandies/typechemique")
    public String getMarchandiestypechemique() {
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
                    "SELECT ?marchandies ?nomMarchandies ?typeMarchandies ?uniteMarchandies ?poidsMarchandies\n" +
                    "WHERE {\n" +
                    "?marchandies rdf:type ns:Marchandies .\n" +
                    "?marchandies ns:nomMarchandies ?nomMarchandies .\n" +
                    "?marchandies ns:typeMarchandies ?typeMarchandies .\n" +
                    "?marchandies ns:uniteMarchandies ?uniteMarchandies .\n" +
                    "?marchandies ns:poidsMarchandies ?poidsMarchandies .\n" +
                    "FILTER (?typeMarchandies = \"chimiques\") .\n" +
                    "}ORDER BY (?poidsMarchandies)";
            String jsonString = JenaEngine.executeQuery(inferedModel,q);
            return jsonString ;
        }
        return null;
    }
}
