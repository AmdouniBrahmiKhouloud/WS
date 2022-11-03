package com.example.jena;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.VCARD;

public class main {

	public static void main(String[] args) {

		String NS = "";
		// lire le model a partir d'une ontologie
		Model model = JenaEngine.readModel("data/Famille.owl");

		if (model != null) {
		//lire le Namespace de l’ontologie
		NS = model.getNsPrefixURI("");

		// apply our rules on the owlInferencedModel
		Model inferedModel = JenaEngine.readInferencedModelFromRuleFile(model, "data/rules.txt");
		System.out.print(JenaEngine.executeQueryFile(inferedModel,"data/query.txt"));
		//model.write(System.out,"RDF/JSON");
		// query on the model after inference
		} else {
		System.out.println("Error when reading model from ontology");
		}
		}

	}


