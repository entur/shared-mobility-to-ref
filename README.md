# shared-mobility-to-ref

Reference implementation of a backend that implements a [TOMP API](https://github.com/TOMP-WG/TOMP-API) from the TO (Transport Operator) side.

# Backend Setup Guide

Welcome to our backend setup guide. In order to get started, there are a few requirements and recommendations that will ensure a smooth setup process.

## Requirements

### Oracle OpenJDK

Our project requires **Oracle OpenJDK version 21.0.2**. It's essential for running our application, so please make sure this specific version is installed on your system. You can download it directly from the [Oracle website](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html) or use a version manager like SDKMAN! to install it.

### Commit Signature Verification

To enhance the security and integrity of our codebase, we require all commits to be signed. If you're not familiar with the process of signing commits, GitHub provides a comprehensive guide on [Generating a New GPG Key](https://docs.github.com/en/authentication/managing-commit-signature-verification/generating-a-new-gpg-key) which you can follow to set up commit signing.

## Recommendations

### SDKMAN!

For managing Java SDKs and tools like Gradle, we highly recommend using [SDKMAN!](https://sdkman.io/). It simplifies the installation and management of multiple software development kits on Unix-based systems, including macOS and Windows (via Git Bash, although this hasn't been tested by us). With SDKMAN!, you can easily install specific versions of JDK (including Oracle OpenJDK 21.0.2) and the latest version of Gradle without the need to browse the internet for downloads.

#### Installing SDKMAN!

On Unix-based systems and macOS:

```bash
curl -s "https://get.sdkman.io" | bash"
```

#### After Installation

Open a new terminal and install the required JDK version by running:

```bash
sdk install java 21.0.2-open
```

#### SDKMAN! Initialization
Ensure that SDKMAN! is correctly initialized in your shell's startup script. SDKMAN! usually adds an initialization command in .bashrc, .bash_profile, .zshrc, or a similar file depending on which shell you're using. Check that this line exists and is functioning properly:

```bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
```

#### Viewing Installed Java Versions with SDKMAN!
To see which Java versions you have actually installed with SDKMAN!, you can use the command sdk current java to see the current active version, or sdk list java and look for those marked with an asterisk (*) or another indicator in the list. However, to get a specific list of all installed Java versions, you can use the following command:

```bash
sdk list java | grep -E "installed|local only"
```

If you only want to see the current active version, you can run:

```bash
sdk current java
```

To install the latest version of Gradle:

```bash
sdk install gradle
```

Tips and Tricks
Switching between JDK versions: SDKMAN! makes it easy to switch between different JDK versions. This can be particularly useful if you're working on multiple projects that require different Java versions.

Using Gradle: With SDKMAN!, you can ensure that you're using the latest version of Gradle, which is essential for efficiently building our project.

Need help? If you have any questions or encounter any issues during the setup process, don't hesitate to ask. Our team is here to help and ensure that everything runs smoothly.

Thank you for setting up your environment according to these guidelines. Happy coding!
