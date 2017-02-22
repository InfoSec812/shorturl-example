package com.zanclus.symphony;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;

/**
 * A class which can be used to generate a shortened URL mapped to a full-length URL in as few characters as possible.
 */
public class ShortURL {
    private Map<String, String> urlMappings = new HashMap<>();
    private static final char[] alphaNumerics = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                                    .toCharArray();
    private BigInteger incrementor = ZERO;

    /**
     * Create a new mapping to a short URL or retrieve an existing mapping for a given URL
     * @param url The URL which should be mapped to a short URL
     * @return The shortened URL string
     */
    public String set(String url) {
        String shortUrl = null;
        if (urlMappings.containsValue(url)) {
            shortUrl = urlMappings.get(url);
        } else {
            shortUrl = bigIntToString(incrementor);

            // Store the reverse mapping as well as the forward mapping for retrieval purposes.
            urlMappings.put(url, shortUrl);
            urlMappings.put(shortUrl, url);
            incrementor = incrementor.add(ONE);
        }
        return shortUrl;
    }

    /**
     * Retrieve the full length URL from the mapping when presented the short URL
     * @param shortURL The ShortURL
     * @return The original long-form URL
     */
    public String get(String shortURL) {
        return urlMappings.get(shortURL);
    }

    /**
     * Convert the {@link BigInteger} value to a Base62 string using the alphaNumerics array
     * @param num The input value to be converted
     * @return A string which represents the number as a Base62 integer
     */
    String bigIntToString(BigInteger num) {
        final StringBuilder sb = new StringBuilder();
        BigInteger accumulator = num;
        do {
            int rem = accumulator.remainder(BigInteger.valueOf(62L)).intValue();
            sb.append(alphaNumerics[rem]);
            accumulator = accumulator.divide(BigInteger.valueOf(62L));
        } while (accumulator.compareTo(ZERO)>0);
        return sb.reverse().toString();
    }
}
