# JNoise
![banner](banner.png)

[![license](https://img.shields.io/github/license/articdive/JNoise.svg?style=for-the-badge)](../LICENSE)
[![GitHub release (latest by date)](https://img.shields.io/github/v/release/Articdive/JNoise?style=for-the-badge)](https://github.com/Articdive/JNoise/releases)
[![standard-readme compliant](https://img.shields.io/badge/readme%20style-standard-brightgreen.svg?style=for-the-badge)](https://github.com/RichardLitt/standard-readme)
[![Discord](https://img.shields.io/discord/525595722859675648?label=discord&style=for-the-badge)](https://discord.gg/JnksJCFkE4)

JNoise is a simple to use java-library for generating noise (including gradient noise) in Java.

JNoise was created in early 2020 by Articdive. It was created for a project in Minecraft for custom terrain generation.
It works for all Java 8+ apps and is built using [Gradle](https://gradle.org/).

## Table of Contents
- [Install](#install)
- [Usage](#usage)
- [Maintainers](#maintainers)
- [Acknowledgements](#acknowledgements)
- [Contributing](#contributing)
- [License](#license)

## Install
### Maven & Gradle
To add JNoise to your project using [Gradle](https://gradle.org/) or [Maven](http://maven.apache.org/):

Repository (Maven):
```
<repository>
    <id>Jitpack</id>
    <url>https://jitpack.io</url>
</repository>
```
Dependency (Maven):
```
<dependency>
    <groupId>com.github.Articdive</groupId>
    <artifactId>JNoise</artifactId>
    <version>VERSION</version>
</dependency>
```

Repository (Gradle Kotlin DSL)
```
repositories {
    maven {
        name = "Jitpack"
        url = uri("https://jitpack.io")
    }
}
```
Dependency (Gradle Kotlin DSL)
```
dependencies {
    // JNoise Library
    implementation("com.github.Articdive:JNoise:VERSION")
}
```
## Usage

### Picking your Noise Algorithm.
The JNoise library supports "Perlin", "OpenSimplex", "Value", "Worley" and "White" noise.

It also supports octavated (fractal) versions of all noise types.

Every noise-type has different customizable features, e.g. Perlin Noise has different types of interpolation to choose from and Worley Noise's point distribution can be altered.

Normally if you are using an IDE, the code-completition is intuitive enough to use this library without having to check the source-code.

Example: Creating a noise-generator using Perlin Noise with cosine interpolation.
```java
        JNoise perlinCosine = JNoise.newBuilder().perlin().setInterpolation(InterpolationType.COSINE).setSeed(1729).build();
```

### Getting Noise Values
The Noise's dimension has to do with the amount of parameters. If you add two doubles after the getNoise method, you will receive 2 dimensional noise.

Nearly All Noise Implementations support 2D, 3D and 4D noise.

Example: Getting 2D Perlin-Noise:
```java
    public JNoise perlinLinear = JNoise.newBuilder().perlin().setInterpolation(InterpolationType.LINEAR).setSeed(1629).build();
    public double getNoise(double x, double y) {
        // 1D Noise
        return perlinLinear.getNoise(x, y)
    }
```
Example: Getting 3D Perlin-Noise:
```java
    public JNoise perlinLinear = JNoise.newBuilder().perlin().setInterpolation(InterpolationType.LINEAR).setSeed(1629).build();
    public double getNoise(double x, double y, double z) {
        // 3D Noise
        return perlinLinear.getNoise(x, y, z)
    }
```

### Getting Octavated (Fractal) Noise Values
In this case way to get noise values is the exact same (using getNoise()), except in the creation of your builder you use the octavated noise type
and supply a noise-type to octavate.

Example: Creating a noise-generator using octavated Perlin Noise with cosine interpolation.
```java
        public JNoise octavatedPerlin = JNoise.newBuilder().octavated().setNoise(
            JNoise.newBuilder().perlin().setInterpolation(InterpolationType.COSINE).setSeed(1629)
        ).setOctaves(4).setPersistence(0.5).setLacunarity(0.5).build();
```

### Customizable Features
All noise types have a customizable seed and frequency.
#### Perlin & Value Noise
- Interpolation function
- Fade function
#### Worley Noise
- Distance function
- Feature point amount
#### OpenSimplex Noise
- Fast & SuperSimplex algorithms
- Simplex variants
#### Octavated Noise
- The underlying noise type to be octavated
- Amount of octaves
- Lacunarity
- Persistance / Gain
- Fractal functions
- Seed incrementation per octave (Increases the seed by 1 each octave)

## Maintainers
[@Articdive](https://www.github.com/Articdive/)

## Acknowledgements
[@Ken Perlin](https://mrl.nyu.edu/~perlin/)'s work on Perlin Noise.

[@Kurt Spencer](https://www.github.com/KDotJpg)'s work on OpenSimplex2 located [here](https://github.com/KdotJPG/OpenSimplex2).

[@Steven Worley](http://weber.itn.liu.se/~stegu/TNM084-2017/worley-originalpaper.pdf)'s work on Worley Noise.

## Contributing
See [the contributing file](CONTRIBUTING.md)!

## License
[GNU General Public License v3.0 or later © Articdive ](../LICENSE)