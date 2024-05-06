
### Helm:
Helm resembles a package manager for Kubernetes that allows you to define, install, and manage Kubernetes applications. Helm uses a package format called "charts," which is a collection of files that describe a related set of Kubernetes resources. Helm helps manage application releases, handle dependencies between charts, and simplify the deployment and management of Kubernetes applications.

We will primarily use Helm to keep track of different values in different environments and use Helm only to generate so-called manifest files used by Kubernetes.

### Use of the commands:

1) **helm dependency update ./shared-mobility-to-ref**
    - This command updates the dependencies for the Helm chart in the `./shared-mobility-to-ref` folder. If the chart has defined external dependencies in its `Chart.yaml`, `helm dependency update` will download and place these dependency charts in the `charts/` subfolder. This ensures that all necessary dependencies are in place and updated before you install or upgrade the chart.

2) **helm lint -f helm/shared-mobility-to-ref/env/values-kub-ent-dev.yaml ./helm/shared-mobility-to-ref/**
    - This command checks the Helm chart in `./helm/shared-mobility-to-ref/` for errors and best practices by using the values defined in `values-kub-ent-dev.yaml`. `helm lint` helps ensure that your chart is well-structured and free of common errors before distribution.

   **The lint command is run on the project with each individual values-kub-ent-*.yaml as input for linting.**

3) **cd helm/shared-mobility-to-ref && helm template shared-mobility-to-ref -n shared-mobility-to-ref . -f env/values-kub-ent-dev.yaml**
    - When you navigate to the `helm/shared-mobility-to-ref` directory and run this command, you generate Kubernetes manifest files from the Helm chart using the configurations in `values-kub-ent-dev.yaml`. This gives you the opportunity to see how the chart is rendered and ensures that it makes sense and matches your expectations before applying it in an environment.

By using these commands, you ensure that your Helm chart is correctly configured, the dependencies are updated, and the chart can be successfully deployed in your Kubernetes cluster.

To run a dry run with `kubectl apply` based on the output from `helm template`, you can add `--dry-run=client` (for client-side validation) or `--dry-run=server` (for server-side validation) to the `kubectl apply` command. Here's how you do it:

### Client-side Dry Run:

```bash
helm template shared-mobility-to-ref -n shared-mobility-to-ref . -f env/values-kub-ent-dev.yaml | kubectl apply --dry-run=client -f -
```

### Server-side Dry Run:

```bash
helm template shared-mobility-to-ref -n shared-mobility-to-ref . -f env/values-kub-ent-dev.yaml | kubectl apply --dry-run=server -f -
```

In these commands:

- `helm template shared-mobility-to-ref -n shared-mobility-to-ref . -f env/values-kub-ent-dev.yaml` generates the Kubernetes manifests based on the Helm chart `shared-mobility-to-ref` with values from `env/values-kub-ent-dev.yaml`.

- `|` (pipe) sends this output directly to `kubectl apply`.

- `--dry-run=client` or `--dry-run=server` tells `kubectl` to perform a dry run, which simulates applying the manifests without actually doing it.

- `-f -` tells `kubectl` to read the manifests from standard input (stdin), which in this case is the output from `helm template`.

This allows you to see the results of what would have been applied to your Kubernetes cluster without actually making the changes, providing a good opportunity to validate the changes before they are actually applied.