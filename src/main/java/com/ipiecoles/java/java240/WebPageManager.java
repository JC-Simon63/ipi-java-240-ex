package com.ipiecoles.java.java240;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.StringJoiner;

@Service
public class WebPageManager {

    private HashMap<String, String> cacheContent = new HashMap<>();

    /**
     * Fait une requête GET à l'url passée en paramètre
     * @param address URL à contacter
     * @return le contenu renvoyé par la requête GET
     * @throws IOException si l'adresse n'a pas pu être contactée.
     */
    public String getPageContents(String address) throws IOException {
        System.out.println("Consultation de l'adresse " + address);
        BufferedReader br = null;
        StringJoiner lines = new StringJoiner(System.lineSeparator());

        try {
            URL url = new URL(address);
            br = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } finally {
            if (br != null) {
                br.close();
            }
        }
        return lines.toString();

    }

    /**
     * Fait appel à getPageContents si l'adresse n'a jamais été jointe auparavant, sinon renvoie le contenu de l'appel précédent
     * @param address URL à contacter
     * @return Le contenu en cache (si déjà consulté) de la page située à l'adresse en paramètre
     * @throws IOException si l'adresse n'a pas pu être contactée.
     */
    public String getPageContentsFromCacheIfExists(String address) throws IOException {
        if(cacheContent.containsKey(address)){
            System.out.println("Récupération dans le cache...");
            return cacheContent.get(address);
        } else {
            return getPageContents(address);
        }
    }

}