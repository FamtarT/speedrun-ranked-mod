# Contributing to Speedrun Ranked

## How to Contribute

We welcome contributions! Here's how to get started.

### Prerequisites

- Java 8 or later
- Git
- Gradle (included)
- Minecraft 1.16.1 knowledge
- Fabric API knowledge (optional)

### Setting Up Development Environment

1. **Fork the Repository**
   ```bash
   # Go to https://github.com/FamtarT/speedrun-ranked-mod
   # Click "Fork" button
   ```

2. **Clone Your Fork**
   ```bash
   git clone https://github.com/YOUR_USERNAME/speedrun-ranked-mod.git
   cd speedrun-ranked-mod
   ```

3. **Add Upstream Remote**
   ```bash
   git remote add upstream https://github.com/FamtarT/speedrun-ranked-mod.git
   ```

4. **Generate IDE Project**

   **IntelliJ IDEA:**
   ```bash
   ./gradlew idea
   open speedrun-ranked-mod.iml
   ```

   **Eclipse:**
   ```bash
   ./gradlew eclipse
   ```

5. **Build and Test**
   ```bash
   ./gradlew build
   ```

### Making Changes

1. **Create a Feature Branch**
   ```bash
   git checkout -b feature/your-feature-name
   ```

2. **Make Your Changes**
   - Follow the existing code style
   - Use clear variable names
   - Add comments for complex logic

3. **Commit Your Changes**
   ```bash
   git add .
   git commit -m "Add: description of your changes"
   ```

4. **Push to Your Fork**
   ```bash
   git push origin feature/your-feature-name
   ```

5. **Create a Pull Request**
   - Go to GitHub
   - Click "New Pull Request"
   - Select your fork and branch
   - Add description of changes
   - Click "Create Pull Request"

## Code Style Guide

### Java Conventions

```java
// Use descriptive names
private static final int COUNTDOWN_DURATION = 3;

// Document public methods
/**
 * Starts a new ranked run.
 * @return true if successful, false otherwise
 */
public boolean startRankedRun() {
    // implementation
}

// Use meaningful variable names
int currentRating = ratingManager.getCurrentRating();

// Add comments for non-obvious logic
// Check if run integrity is valid before completing
if (integrityManager.checkIntegrity()) {
    completeRun();
}
```

### Naming Conventions

- **Classes**: PascalCase (e.g., `RatingManager`)
- **Methods**: camelCase (e.g., `startRankedRun`)
- **Constants**: UPPER_SNAKE_CASE (e.g., `COUNTDOWN_DURATION`)
- **Variables**: camelCase (e.g., `currentRating`)
- **Packages**: lowercase.with.dots (e.g., `com.speedrunranked.rating`)

### File Organization

```
src/main/java/com/speedrunranked/
├── feature/
│   ├── FeatureManager.java
│   ├── Feature.java
│   └── ...
├── util/
│   ├── UtilClass.java
│   └── ...
└── Main.java
```

## Testing

Before submitting a PR:

```bash
# Build and run tests
./gradlew build

# Check for errors
./gradlew check

# Clean rebuild
./gradlew clean build
```

## Areas for Contribution

### High Priority
- 🎯 GapCheck API integration
- 🎯 Network client for seed fetching
- 🎯 Enhanced GUI screens
- 🎯 Configuration file support
- 🎯 Leaderboard system

### Medium Priority
- 📊 Statistics improvements
- 📊 Split tracking UI
- 📊 Run replay system
- 📊 Seed filtering

### Low Priority
- 🎨 Custom themes/skins
- 🎨 Sound effects
- 🎨 Animations
- 🎨 Localization

## Pull Request Guidelines

### Before Submitting

- [ ] Code builds without errors
- [ ] No unrelated changes
- [ ] Follows code style guide
- [ ] Comments added for complex logic
- [ ] PR title is descriptive
- [ ] PR description explains changes

### PR Title Format

```
Add: New feature name
Fix: Bug description
Improve: Improvement description
Refactor: Code cleanup description
Docs: Documentation updates
```

### PR Description Template

```markdown
## Description
Brief description of changes

## Type of Change
- [ ] Bug fix
- [ ] New feature
- [ ] Breaking change
- [ ] Documentation update

## Related Issues
Closes #123

## Testing
How to test these changes

## Screenshots (if applicable)
```

## Reporting Issues

### Bug Report Template

```markdown
## Description
Clear description of the bug

## Steps to Reproduce
1. First step
2. Second step
3. ...

## Expected Behavior
What should happen

## Actual Behavior
What actually happens

## Environment
- OS: Windows/Mac/Linux
- Java Version: 11
- Minecraft Version: 1.16.1
- Mod Version: 1.0.0

## Logs
```
Paste relevant logs here
```

## Screenshots
Attach screenshots if helpful
```

## Commit Guidelines

### Good Commit Messages

```
Add countdown timer implementation

- Implement 3-second countdown before run
- Add countdown display to HUD
- Configure countdown duration in settings
```

### Avoid

```
fixed stuff
wip
updates
changes
```

## Documentation

When adding features:

1. Update `README.md` with new features
2. Update code comments
3. Add examples if applicable
4. Update `INSTALLATION.md` if needed

## Questions?

- 💬 Ask in [GitHub Discussions](https://github.com/FamtarT/speedrun-ranked-mod/discussions)
- 📧 Open an issue for clarification
- 🐛 Check existing issues first

## Code of Conduct

- Be respectful
- Provide constructive feedback
- Help others learn
- Report issues responsibly

## License

By contributing, you agree that your contributions will be licensed under the MIT License.

---

Thank you for contributing! 🎉
