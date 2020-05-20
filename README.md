# conversions project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```
./mvnw quarkus:dev
```

## Packaging and running the application

The application can be packaged using `./mvnw package`.
It produces the `conversions-1.0-SNAPSHOT-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

The application is now runnable using `java -jar target/conversions-1.0-SNAPSHOT-runner.jar`.

## Creating a native executable

You can create a native executable using: `./mvnw package -Pnative`.

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: `./mvnw package -Pnative -Dquarkus.native.container-build=true`.

You can then execute your native executable with: `./target/conversions-1.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image.

## Endpoints

/conversions/ktoc
The ktoc endpoint should produce an output amount in celsius when given an input amount in kelvin.

/conversions/ctok
The ctok endpoint should produce an output amount in kelvin when given an input amount in celsius.

/conversions/mtok
The mtok endpoint should produce, when given an input amount in miles, an output amount in kilometers.

/conversions/ktom
The ktom endpoint should produce, when given an input amount in kilometers, an output amount in miles.
