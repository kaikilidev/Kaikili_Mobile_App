package com.sit.kaikiliService.api;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;

import retrofit.converter.ConversionException;
import retrofit.converter.Converter;
import retrofit.mime.TypedInput;
import retrofit.mime.TypedOutput;

/**
 * Created by ketan patel on 9/2/2019.
 * ketan_patel25@yahoo.com
 * Sharva Infotech PVT LTD
 *
 */

/**
 * A {@link Converter} which uses parsing and serialization provided by bluelinelabs' LoganSquare library.
 *
 * @author aurae
 */
public class LoganSquareConverter implements Converter {

    @Override public Object fromBody(TypedInput typedInput, Type type) throws ConversionException {
        try {
            InputStream in = typedInput.in(); // convert the typedInput to String
            String string = fromStream(in);
            in.close(); // we are responsible to close the InputStream after use

            if (String.class.equals(type)) {
                return string;
            } else {
                return new Gson().fromJson(string, type); // convert to the supplied type, typically Object, JsonObject or Map<String, Object>
            }
        } catch (Exception e) { // a lot may happen here, whatever happens
            throw new ConversionException(e); // wrap it into ConversionException so retrofit can process it
        }
    }

    @Override public TypedOutput toBody(Object object) { // not required
        return null;
    }

    private static String fromStream(InputStream in) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder out = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            out.append(line);
            out.append("\r\n");
        }
        return out.toString();
    }

//
//    @Override
//    public Object fromBody(TypedInput body, Type type) throws ConversionException {
//        try {
//            // Check if the type contains a parametrized list
//            if (ParameterizedType.class.isAssignableFrom(type.getClass())) {
//                // Grab the actual type parameter from the parametrized list and delegate to LoganSquare
//                ParameterizedType parameterized = (ParameterizedType) type;
//                return LoganSquare.parseList(body.in(), (Class) parameterized.getActualTypeArguments()[0]);
//
//            } else {
//                // Single elements get parsed immediately
//                Log.e( "post Data --------",LoganSquare.parse(body.in(), (Class) type).toString());
//
//                return LoganSquare.parse(body.in(), (Class) type);
//            }
//        } catch (Exception e) {
//            throw new ConversionException(e);
//        }
//    }
//
//    @SuppressWarnings("unchecked")
//    @Override
//    public TypedOutput toBody(Object object) {
//        try {
//            // Check if the type contains a parametrized list
//            if (List.class.isAssignableFrom(object.getClass())) {
//                // Convert the input to a list first, access the first element and serialize the list
//                List<Object> list = (List<Object>) object;
//                if (list.isEmpty()) {
//                    return new TypedString("[]");
//                } else {
//                    Object firstElement = list.get(0);
//                    Log.e( "Out put ------", firstElement.toString());
//                    return new TypedString(LoganSquare.serialize(list, (Class<Object>) firstElement.getClass()));
//                }
//            } else {
//                // Serialize single elements immediately
//                return new TypedString(LoganSquare.serialize(object));
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
}
