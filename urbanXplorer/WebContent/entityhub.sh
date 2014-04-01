#!/bin/bash

echo "ajout des données dans le site (europena)"

# changer le content pour turtle 
# changer le nom du fichier
#curl -i -X POST -H "Content-Type:application/x-turtle" -T {cog-2012.ttl} "http://localhost:8080/entityhub/site/iptc/entity"
#curl -i -X POST -H "Content-Type:application/rdf+xml" -T {03709_M_FR_CiteMusique_IN.rdf} "http://localhost:8080/entityhub/site/europeana/entity"
#echo "donnees ajoutees"
#curl -H "Accept:application/rdf+xml" "http://localhost:8080/entityhub/site/iptc/entity?id=http://id.insee.fr/geo/commune/25170"
curl -H "Accept:application/rdf+xml" "http://localhost:8080/entityhub/site/europeana/entity?id=http://data.europeana.eu/item/03709/7615F4D92BB9B66031A3D058FCE2E222AD3B164F"
#curl -H "Accept:application/rdf+xml" "http://localhost:8080/entityhub/site/europeana/entity?id=http://data.europeana.eu/aggregation/provider/03709/7615F4D92BB9B66031A3D058FCE2E222AD3B164F"


