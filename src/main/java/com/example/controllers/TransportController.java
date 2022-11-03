package com.example.controllers;

import com.example.jena.JenaEngine;
import org.apache.jena.rdf.model.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/Transport")
public class TransportController {
    /*http://localhost:8080/Transport/Marchandies*/
    @GetMapping("/")
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
                    "SELECT ?transport ?marque ?model ?dateDepart ?dateArrivee\n" +
                    "WHERE {\n" +
                    "?transport rdf:type ns:Transport .\n" +
                    "?transport ns:marque ?marque.\n" +
                    "?transport ns:model ?model.\n" +
                    "?transport ns:dateDepart ?dateDepart.\n" +
                    "?transport ns:dateArrivee ?dateArrivee.\n" +
                    "}";
            String jsonString = JenaEngine.executeQuery(inferedModel,q);
            return jsonString ;
        }
        return null;
    }

    /*http://localhost:8080/Transport/Marchandies*/
    @GetMapping("/ordred")
    public String getOrdredMarchandies() {
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
                    "SELECT ?transport ?marque ?model ?dateDepart ?dateArrivee\n" +
                    "WHERE {\n" +
                    "?transport rdf:type ns:Transport .\n" +
                    "?transport ns:marque ?marque.\n" +
                    "?transport ns:model ?model.\n" +
                    "?transport ns:dateDepart ?dateDepart.\n" +
                    "?transport ns:dateArrivee ?dateArrivee.\n" +
                    "}ORDER BY (?dateDepart)";
            String jsonString = JenaEngine.executeQuery(inferedModel,q);
            return jsonString ;
        }
        return null;
    }
    /*http://localhost:8080/Transport/Marchandies*/
    @GetMapping("/parEnergie")
    public String getEnergie() {
        String NS = "";
        // lire le model a partir d'une ontologie
        Model model = JenaEngine.readModel("data/Ws_Transport.owl");

        if (model != null) {
            //lire le Namespace de l’ontologie
            NS = model.getNsPrefixURI("");

            // apply our rules on the owlInferencedModel
            Model inferedModel = JenaEngine.readInferencedModelFromRuleFile(model, "data/rules.txt");
            String q ="    PREFIX ns: <http://www.semanticweb.org/khouloud/ontologies/2022/9/WS_Transport#>\n" +
                    "       PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                    "        SELECT ?transport ?marque ?model ?typeEnergie\n" +
                    "        WHERE {\n" +
                    "        ?transport rdf:type ns:Transport .\n" +
                    "        ?transport ns:marque ?marque.\n" +
                    "        ?transport ns:model ?model.\n" +
                    "        ?energie rdf:type ns:Energie .\n" +
                    "        ?energie ns:typeEnergie ?typeEnergie .\n" +
                    "        }";
            String jsonString = JenaEngine.executeQuery(inferedModel,q);
            return jsonString ;
        }
        return null;
    }

    @GetMapping("/aerien")
    public String getAerien() {
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
                    "SELECT ?arrien ?marque ?model ?dateDepart ?dateArrivee\n" +
                    "WHERE {\n" +
                    "?arrien rdf:type ns:Aérien .\n" +
                    "?arrien ns:marque ?marque.\n" +
                    "?arrien ns:model ?model.\n" +
                    "?arrien ns:dateDepart ?dateDepart.\n" +
                    "?arrien ns:dateArrivee ?dateArrivee.\n" +
                    "}";
            String jsonString = JenaEngine.executeQuery(inferedModel,q);
            return jsonString ;
        }
        return null;
    }
    @GetMapping("/aerien/ordred")
    public String getAerienOrdred() {
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
                    "SELECT ?arrien ?marque ?model ?dateDepart ?dateArrivee\n" +
                    "WHERE {\n" +
                    "?arrien rdf:type ns:Aérien .\n" +
                    "?arrien ns:marque ?marque.\n" +
                    "?arrien ns:model ?model.\n" +
                    "?arrien ns:dateDepart ?dateDepart.\n" +
                    "?arrien ns:dateArrivee ?dateArrivee.\n" +
                    "}ORDER BY (?dateArrivee)";
            String jsonString = JenaEngine.executeQuery(inferedModel,q);
            return jsonString ;
        }
        return null;
    }


    @GetMapping("/maritime")
    public String getMaritime() {
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
                    "SELECT ?maritime ?marque ?model ?dateDepart ?dateArrivee\n" +
                    "WHERE {\n" +
                    "?maritime rdf:type ns:Maritime .\n" +
                    "?maritime ns:marque ?marque.\n" +
                    "?maritime ns:model ?model.\n" +
                    "?maritime ns:dateDepart ?dateDepart.\n" +
                    "?maritime ns:dateArrivee ?dateArrivee.\n" +
                    "}";
            String jsonString = JenaEngine.executeQuery(inferedModel,q);
            return jsonString ;
        }
        return null;
    }

    @GetMapping("/maritime/ordred")
    public String getMaritimeOrdred() {
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
                    "SELECT ?maritime ?marque ?model ?dateDepart ?dateArrivee\n" +
                    "WHERE {\n" +
                    "?maritime rdf:type ns:Maritime .\n" +
                    "?maritime ns:marque ?marque.\n" +
                    "?maritime ns:model ?model.\n" +
                    "?maritime ns:dateDepart ?dateDepart.\n" +
                    "?maritime ns:dateArrivee ?dateArrivee.\n" +
                    "}ORDER BY (?dateArrivee)";
            String jsonString = JenaEngine.executeQuery(inferedModel,q);
            return jsonString ;
        }
        return null;
    }

    @GetMapping("/routier")
    public String getRoutier() {
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
                    "SELECT ?routier ?marque ?model ?dateDepart ?dateArrivee\n" +
                    "WHERE {\n" +
                    "?routier rdf:type ns:Routier .\n" +
                    "?routier ns:marque ?marque.\n" +
                    "?routier ns:model ?model.\n" +
                    "?routier ns:dateDepart ?dateDepart.\n" +
                    "?routier ns:dateArrivee ?dateArrivee.\n" +
                    "}";
            String jsonString = JenaEngine.executeQuery(inferedModel,q);
            return jsonString ;
        }
        return null;
    }

    @GetMapping("/routier/peugeot")
    public String getpeugeot() {
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
                    "SELECT ?routier ?marque ?model ?dateDepart ?dateArrivee\n" +
                    "WHERE {\n" +
                    "?routier rdf:type ns:Routier .\n" +
                    "?routier ns:marque ?marque.\n" +
                    "?routier ns:model ?model.\n" +
                    "?routier ns:dateDepart ?dateDepart.\n" +
                    "?routier ns:dateArrivee ?dateArrivee.\n" +
                    "FILTER (?marque= \"Peugeot\") .\n" +
                    "}";
            String jsonString = JenaEngine.executeQuery(inferedModel,q);
            return jsonString ;
        }
        return null;
    }

    @GetMapping("/routier/ordred")
    public String getRoutierOrdred() {
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
                    "SELECT ?routier ?marque ?model ?dateDepart ?dateArrivee\n" +
                    "WHERE {\n" +
                    "?routier rdf:type ns:Routier .\n" +
                    "?routier ns:marque ?marque.\n" +
                    "?routier ns:model ?model.\n" +
                    "?routier ns:dateDepart ?dateDepart.\n" +
                    "?routier ns:dateArrivee ?dateArrivee.\n" +
                    "}ORDER BY (?dateDepart)";
            String jsonString = JenaEngine.executeQuery(inferedModel,q);
            return jsonString ;
        }
        return null;
    }


    @GetMapping("/ferroviaire")
    public String getFerroviaire() {
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
                    "SELECT ?ferroviaire ?marque ?model ?dateDepart ?dateArrivee\n" +
                    "WHERE {\n" +
                    "?ferroviaire rdf:type ns:Ferroviaire .\n" +
                    "?ferroviaire ns:marque ?marque.\n" +
                    "?ferroviaire ns:model ?model.\n" +
                    "?ferroviaire ns:dateDepart ?dateDepart.\n" +
                    "?ferroviaire ns:dateArrivee ?dateArrivee.\n" +
                    "}";
            String jsonString = JenaEngine.executeQuery(inferedModel,q);
            return jsonString ;
        }
        return null;
    }

    @GetMapping("/ferroviaire/ordred")
    public String getFerroviaireOrdred() {
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
                    "SELECT ?ferroviaire ?marque ?model ?dateDepart ?dateArrivee\n" +
                    "WHERE {\n" +
                    "?ferroviaire rdf:type ns:Ferroviaire .\n" +
                    "?ferroviaire ns:marque ?marque.\n" +
                    "?ferroviaire ns:model ?model.\n" +
                    "?ferroviaire ns:dateDepart ?dateDepart.\n" +
                    "?ferroviaire ns:dateArrivee ?dateArrivee.\n" +
                    "}ORDER BY (?dateDepart)";
            String jsonString = JenaEngine.executeQuery(inferedModel,q);
            return jsonString ;
        }
        return null;
    }

    @GetMapping("/vehicule")
    public String getVehicule() {
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
                    "SELECT ?Vehicule ?marque ?model ?dateDepart ?dateArrivee\n" +
                    "WHERE {\n" +
                    "?Vehicule rdf:type ns:Véhicule .\n" +
                    "?Vehicule ns:marque ?marque.\n" +
                    "?Vehicule ns:model ?model.\n" +
                    "?Vehicule ns:dateDepart ?dateDepart.\n" +
                    "?Vehicule ns:dateArrivee ?dateArrivee.\n" +
                    "}";
            String jsonString = JenaEngine.executeQuery(inferedModel,q);
            return jsonString ;
        }
        return null;
    }

    @GetMapping("/vehicule/iveco")
    public String getIveco() {
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
                    "SELECT ?Vehicule ?marque ?model ?dateDepart ?dateArrivee\n" +
                    "WHERE {\n" +
                    "?Vehicule rdf:type ns:Véhicule .\n" +
                    "?Vehicule ns:marque ?marque.\n" +
                    "?Vehicule ns:model ?model.\n" +
                    "?Vehicule ns:dateDepart ?dateDepart.\n" +
                    "?Vehicule ns:dateArrivee ?dateArrivee.\n" +
                    "FILTER (?marque = \"Iveco\") .\n" +
                    "}ORDER BY (?dateDepart)";
            String jsonString = JenaEngine.executeQuery(inferedModel,q);
            return jsonString ;
        }
        return null;
    }

    @GetMapping("/vehicule/ordred")
    public String getVehhiculeOrdred() {
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
                    "SELECT ?Vehicule ?marque ?model ?dateDepart ?dateArrivee\n" +
                    "WHERE {\n" +
                    "?Vehicule rdf:type ns:Véhicule .\n" +
                    "?Vehicule ns:marque ?marque.\n" +
                    "?Vehicule ns:model ?model.\n" +
                    "?Vehicule ns:dateDepart ?dateDepart.\n" +
                    "?Vehicule ns:dateArrivee ?dateArrivee.\n" +
                    "}ORDER BY (?dateDepart)";
            String jsonString = JenaEngine.executeQuery(inferedModel,q);
            return jsonString ;
        }
        return null;
    }

}


