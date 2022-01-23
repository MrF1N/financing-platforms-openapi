package by.mrf1n.finance.currencycom.common;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.Properties;

public class YamlPropertySourceFactory implements PropertySourceFactory {

  @Override
  public PropertySource<?> createPropertySource(String name, EncodedResource encodedResource) throws IOException {
    YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();
    factory.setResources(encodedResource.getResource());

    Optional<Properties> properties = Optional.ofNullable(factory.getObject());
    String filename = encodedResource.getResource().getFilename();

    return new PropertiesPropertySource(Objects.requireNonNull(filename), properties.orElseGet(Properties::new));
  }
}
