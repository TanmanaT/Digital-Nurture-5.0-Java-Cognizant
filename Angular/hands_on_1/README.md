# Hands-On 1: Environment Setup, Project Structure & First Component

## Problem Description
Set up the workspace, configure the project directories, analyze config files, and build the initial visual shell/nav bar along with a static Home component showing key portal statistics.

## Topics Covered
- Angular CLI workspace initialization
- Standalone components and entry point structure
- Basic HTML component templating and routing layout integration

## Implementation Details
- **Project Scaffolded**: Generated via Angular CLI with routing and CSS styling enabled.
- **Notes File**: Created `notes.txt` to explain configurations of `angular.json`, budgets, and core configurations.
- **Components Created**:
  - `HeaderComponent`: Renders the portal branding and navigation links.
  - `HomeComponent`: Renders a welcome block and hardcoded dashboards stats.
- **Root Layout Routing**: Configured the default path (`''`) to load `HomeComponent` and render it inside `<router-outlet>`.
