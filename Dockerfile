# Use the latest Ubuntu base image
FROM ubuntu:24.04

# Set environment variables to non-interactive
ENV DEBIAN_FRONTEND=noninteractive

# Update package list and install dependencies for multiple languages
RUN apt-get update && apt-get install -y \
    software-properties-common curl wget gnupg2 lsb-release apt-transport-https ca-certificates libncurses6

# Install R
# Add CRAN repository for the latest R version
RUN echo "deb https://cloud.r-project.org/bin/linux/ubuntu $(lsb_release -c | awk '{print $2}')-cran40/" | tee -a /etc/apt/sources.list
# Add the key for the CRAN repository
RUN curl -fsSL https://cloud.r-project.org/bin/linux/ubuntu/marutter_pubkey.asc | tee /etc/apt/trusted.gpg.d/cran_ubuntu_key.asc
# Update the package list and install R
RUN apt-get update && apt-get install -y r-base

# Install Python
RUN apt-get install -y python3 python3-pip python3-venv \
# Install PHP
    && add-apt-repository ppa:ondrej/php && \
    apt install php8.4 php8.4-cli php8.4-common php8.4-fpm php8.4-mysql php8.4-xml php8.4-gd php8.4-mbstring php8.4-zip php8.4-bcmath  php8.4-curl -y \
# Install Node.js (latest LTS via NodeSource)
    && apt-get install -y nodejs \
# Install Swift (official binary latest stable)
    && curl -O https://download.swift.org/swiftly/linux/swiftly-$(uname -m).tar.gz && \
    tar zxf swiftly-$(uname -m).tar.gz && \
    rm swiftly-$(uname -m).tar.gz && \
    ./swiftly init --quiet-shell-followup && \
    . "${SWIFTLY_HOME_DIR:-$HOME/.local/share/swiftly}/env.sh" && \
    hash -r \
# Install Java (default JDK)
    && apt-get install -y default-jdk \
# Install Golang
    && curl -OL https://go.dev/dl/go1.25.0.linux-amd64.tar.gz && \
    tar -C /usr/local -xzf go1.25.0.linux-amd64.tar.gz && \
    rm go1.25.0.linux-amd64.tar.gz

# Install GCC
RUN add-apt-repository ppa:ubuntu-toolchain-r/ppa -y && \
    apt-get update && \
    apt-get install -y gcc build-essential make

# Install .NET SDK 8 (C# 12)
RUN wget https://packages.microsoft.com/config/ubuntu/$(lsb_release -rs)/packages-microsoft-prod.deb -O packages-microsoft-prod.deb && \
    dpkg -i packages-microsoft-prod.deb && \
    rm packages-microsoft-prod.deb

RUN apt-get update && apt-get install -y dotnet-sdk-8.0

# Install Rust using rustup
RUN curl --proto '=https' --tlsv1.2 -sSf https://sh.rustup.rs | sh -s -- -y

RUN echo 'export PATH="$HOME/.local/share/swiftly/bin:$PATH"' >> ~/.bashrc
RUN echo 'export PATH="$PATH:/usr/local/go/bin"' >> ~/.bashrc
RUN echo 'export PATH="/root/.cargo/bin:${PATH}"' >> ~/.bashrc
RUN . ~/.bashrc

# Clean Up
RUN apt-get clean && rm -rf /var/lib/apt/lists/*

# Default command
CMD ["bash"]
