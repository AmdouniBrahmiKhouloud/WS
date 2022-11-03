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
public class ConteneursController {

    /*Get All Conteneurs*/
    @GetMapping("/Conteneurs")
    public String getConteneurs() throws ParseException, IOException {
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
                    "SELECT ?idConteneur ?longeur ?largeur ?hauteur ?poidsNet ?poidsVolumetrique\n" +
                    "WHERE {\n" +
                    "?conteneurs rdf:type ns:Conteneurs .\n" +
                    "?conteneurs ns:IdConteneur ?idConteneur .\n" +
                    "?conteneurs ns:longeur ?longeur .\n" +
                    "?conteneurs ns:largeur ?largeur .\n" +
                    "?conteneurs ns:hauteur ?hauteur .\n" +
                    "?conteneurs ns:poidsNet ?poidsNet .\n" +
                    "?conteneurs ns:poidsVolumétrique ?poidsVolumetrique .\n" +
                    "}";
            String jsonString = JenaEngine.executeQuery(inferedModel,q);
            return jsonString ;
        }
        return null;
    }
    /*Get All Conteneurs Order By Poids*/
    @GetMapping("/ConteneursOrderByPoids")
    public String getConteneursOrderByPoids() throws ParseException, IOException {
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
                    "SELECT ?idConteneur ?longeur ?largeur ?hauteur ?poidsNet ?poidsVolumetrique\n" +
                    "WHERE {\n" +
                    "?conteneurs rdf:type ns:Conteneurs .\n" +
                    "?conteneurs ns:IdConteneur ?idConteneur .\n" +
                    "?conteneurs ns:longeur ?longeur .\n" +
                    "?conteneurs ns:largeur ?largeur .\n" +
                    "?conteneurs ns:hauteur ?hauteur .\n" +
                    "?conteneurs ns:poidsNet ?poidsNet .\n" +
                    "?conteneurs ns:poidsVolumétrique ?poidsVolumetrique .\n" +
                    "}ORDER BY DESC(?poidsNet)";
            String jsonString = JenaEngine.executeQuery(inferedModel,q);
            return jsonString ;
        }
        return null;
    }
    /*Get All Conteneurs ORDER BY DESC poidsNet && FILTER (?poidsNet >= 28)*/
    @GetMapping("/Conteneurs/WherePoids")
    public String getConteneursWherePoids() throws ParseException, IOException {
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
                    "SELECT ?idConteneur ?longeur ?largeur ?hauteur ?poidsNet ?poidsVolumétrique\n" +
                    "WHERE {\n" +
                    "?conteneurs rdf:type ns:Conteneurs .\n" +
                    "?conteneurs ns:IdConteneur ?idConteneur .\n" +
                    "?conteneurs ns:longeur ?longeur .\n" +
                    "?conteneurs ns:largeur ?largeur .\n" +
                    "?conteneurs ns:hauteur ?hauteur .\n" +
                    "?conteneurs ns:poidsNet ?poidsNet .\n" +
                    "?conteneurs ns:poidsVolumétrique ?poidsVolumétrique .\n" +
                    "FILTER (?poidsNet >= 28) .\n" +
                    "}ORDER BY DESC(?poidsNet)";
            String jsonString = JenaEngine.executeQuery(inferedModel,q);
            return jsonString ;
        }
        return null;
    }
}
