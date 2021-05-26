package com.example.mvrxsample.util

import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.reflect.Type

class XmlAndHtmlConverters {
    @Retention(AnnotationRetention.RUNTIME)
    annotation class HTML

    @Retention(AnnotationRetention.RUNTIME)
    annotation class XML

    @Retention(AnnotationRetention.RUNTIME)
    annotation class Scalars

    class QualifiedTypeConverterFactory constructor(
        var factoryHTML: Converter.Factory, var factoryScalars : Converter.Factory, var factoryXML: Converter.Factory
    ) : Converter.Factory() {
        override fun responseBodyConverter(
            type: Type,
            annotations: Array<out Annotation>,
            retrofit: Retrofit
        ): Converter<ResponseBody, *>? {
            for (annotation in annotations) {
                if (annotation is HTML) return factoryHTML.responseBodyConverter(type, annotations, retrofit)
                if (annotation is Scalars) return factoryScalars.responseBodyConverter(type, annotations, retrofit)
                if (annotation is XML) return factoryXML.responseBodyConverter(type, annotations, retrofit)
            }
            return null
        }

        override fun requestBodyConverter(
            type: Type,
            parameterAnnotations: Array<out Annotation>,
            methodAnnotations: Array<out Annotation>,
            retrofit: Retrofit
        ): Converter<*, RequestBody>? {
            for (annotation in parameterAnnotations) {
                if (annotation is HTML) return factoryHTML.requestBodyConverter(type, parameterAnnotations, methodAnnotations, retrofit)
                if (annotation is Scalars) return factoryScalars.requestBodyConverter(type, parameterAnnotations, methodAnnotations, retrofit)
                if (annotation is XML) return factoryXML.requestBodyConverter(type, parameterAnnotations, methodAnnotations, retrofit)
            }
            return null
        }
    }
}
