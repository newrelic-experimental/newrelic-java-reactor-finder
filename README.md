<a href="https://opensource.newrelic.com/oss-category/#new-relic-experimental"><picture><source media="(prefers-color-scheme: dark)" srcset="https://github.com/newrelic/opensource-website/raw/main/src/images/categories/dark/Experimental.png"><source media="(prefers-color-scheme: light)" srcset="https://github.com/newrelic/opensource-website/raw/main/src/images/categories/Experimental.png"><img alt="New Relic Open Source experimental project banner." src="https://github.com/newrelic/opensource-website/raw/main/src/images/categories/Experimental.png"></picture></a>


![GitHub forks](https://img.shields.io/github/forks/newrelic-experimental/newrelic-java-reactor-finder?style=social)
![GitHub stars](https://img.shields.io/github/stars/newrelic-experimental/newrelic-java-reactor-finder?style=social)
![GitHub watchers](https://img.shields.io/github/watchers/newrelic-experimental/newrelic-java-reactor-finder?style=social)

![GitHub all releases](https://img.shields.io/github/downloads/newrelic-experimental/newrelic-java-reactor-finder/total)
![GitHub release (latest by date)](https://img.shields.io/github/v/release/newrelic-experimental/newrelic-java-reactor-finder)
![GitHub last commit](https://img.shields.io/github/last-commit/newrelic-experimental/newrelic-java-reactor-finder)
![GitHub Release Date](https://img.shields.io/github/release-date/newrelic-experimental/newrelic-java-reactor-finder)


![GitHub issues](https://img.shields.io/github/issues/newrelic-experimental/newrelic-java-reactor-finder)
![GitHub issues closed](https://img.shields.io/github/issues-closed/newrelic-experimental/newrelic-java-reactor-finder)
![GitHub pull requests](https://img.shields.io/github/issues-pr/newrelic-experimental/newrelic-java-reactor-finder)
![GitHub pull requests closed](https://img.shields.io/github/issues-pr-closed/newrelic-experimental/newrelic-java-reactor-finder)


# Reactor Finder

This instrumentation will enable tracking of Java methods which return a Mono or Flux object.  It will track methods in any class that matches a configured package name.

## Installation

To install:

1. Download the latest release jar files.
2. In the New Relic Java directory (the one containing newrelic.jar), create a directory named extensions if it does not already exist.
3. Copy the downloaded jars into the extensions directory.
4. Restart the application.

## Configuration

The packages to match are configured in newrelic.yml.   Note that this instrumentation will not track methods within the Reactor framework.  
   
Packages to track must be inputted as a comma separated  list.   
Note that classes in subpackages will be traced as well.   
   
Use a stanza named reactor-finder.packages to include packages

**Example**   
&nbsp;&nbsp;reactor:
&nbsp;&nbsp;&nbsp;&nbsp;packages: com.mycompany.package1,com.mycompany.package2


## Support

New Relic has open-sourced this project. This project is provided AS-IS WITHOUT WARRANTY OR DEDICATED SUPPORT. Issues and contributions should be reported to the project here on GitHub.

## Contributing

We encourage your contributions to improve [Project Name]! Keep in mind when you submit your pull request, you'll need to sign the CLA via the click-through using CLA-Assistant. You only have to sign the CLA one time per project. If you have any questions, or to execute our corporate CLA, required if your contribution is on behalf of a company, please drop us an email at opensource@newrelic.com.

**A note about vulnerabilities**

As noted in our [security policy](../../security/policy), New Relic is committed to the privacy and security of our customers and their data. We believe that providing coordinated disclosure by security researchers and engaging with the security community are important means to achieve our security goals.

If you believe you have found a security vulnerability in this project or any of New Relic's products or websites, we welcome and greatly appreciate you reporting it to New Relic through [HackerOne](https://hackerone.com/newrelic).

## License

Reactor Finder is licensed under the [Apache 2.0](http://apache.org/licenses/LICENSE-2.0.txt) License.
