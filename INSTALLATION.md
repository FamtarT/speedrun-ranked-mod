# Installation Guide - Speedrun Ranked Mod

## Quick Start

### Requirements
- **Java**: 8 or later (Java 11+ recommended)
- **Minecraft Java Edition**: 1.16.1
- **Fabric Loader**: 0.13.3 or later

### Step 1: Build the Mod

```bash
# Clone the repository
git clone https://github.com/FamtarT/speedrun-ranked-mod.git
cd speedrun-ranked-mod

# Build using Gradle
./gradlew build
```

On Windows, use `gradlew.bat build` instead.

### Step 2: Locate the Built JAR

After a successful build, find the JAR file:

```
speedrun-ranked-mod/build/libs/speedrun-ranked-mod-1.0.0.jar
```

### Step 3: Install Fabric Loader

1. Download **Fabric Installer** from https://fabricmc.net/use/installer/
2. Run the installer
3. Select **"Install Server"** or **"Install Client"**
4. Choose Minecraft version **1.16.1**
5. Choose your Minecraft installation directory
6. Click **"Install"**

### Step 4: Install the Mod

**Windows:**
```
%APPDATA%\.minecraft\mods\speedrun-ranked-mod-1.0.0.jar
```

**macOS:**
```
~/Library/Application Support/minecraft/mods/speedrun-ranked-mod-1.0.0.jar
```

**Linux:**
```
~/.minecraft/mods/speedrun-ranked-mod-1.0.0.jar
```

Create the `mods` folder if it doesn't exist.

### Step 5: Launch Minecraft

1. Open Minecraft Launcher
2. Create a new profile or select existing one
3. Set **Version** to "fabric-loader-0.13.3-1.16.1" (or your Fabric version)
4. Click **"Play"**
5. Wait for Minecraft to load

## First Run

1. Create a **New World**
2. Set to **Survival Mode**
3. Choose any difficulty
4. Generate the world
5. Press **ESC** to open pause menu
6. Look for **"Speedrun Ranked"** option
7. Click **"Start Ranked Run"**
8. Watch the 3-second countdown
9. Begin your speedrun!

## Data Location

All mod data is stored in:

**Windows:**
```
%APPDATA%\.minecraft\config\speedrunranked\
```

**macOS:**
```
~/Library/Application Support/minecraft/config/speedrunranked/
```

**Linux:**
```
~/.minecraft/config/speedrunranked/
```

### Files Generated

```
config/speedrunranked/
├── profile.json        # Your rating and rank
├── runs.json          # All completed runs history
└── seeds-cache.json   # Cached seeds from GapCheck
```

## Troubleshooting

### Issue: Mod doesn't appear in Minecraft

**Solution:**
1. Verify Fabric Loader is installed correctly
2. Check that the JAR is in the correct `mods` folder
3. Restart Minecraft
4. Check Minecraft launcher logs for errors

### Issue: "Unable to find Fabric Loader"

**Solution:**
1. Download Fabric Installer again
2. Reinstall Fabric Loader for 1.16.1
3. Ensure your Minecraft installation path is correct

### Issue: Game crashes on startup

**Solution:**
1. Check crash logs in `.minecraft/crash-reports/`
2. Verify you have Java 8 or later
3. Try removing the mod and reinstalling
4. Check GitHub issues for known problems

### Issue: Rating not changing after runs

**Solution:**
1. Make sure you're in **Ranked Mode**, not Practice
2. Complete at least 5 placement runs first
3. Check that the run wasn't marked invalid (check for errors)
4. Verify runs are being saved to `runs.json`

### Issue: GapCheck seeds not loading

**Solution:**
1. Check your internet connection
2. Try offline mode - local seeds will be used instead
3. Check if GapCheck (https://gapcheck.gg/) is accessible
4. Random seeds will work as fallback

## Building from Source

### Prerequisites
- Git
- Java Development Kit (JDK) 8+
- Gradle (included via wrapper)

### Build Steps

```bash
# Clone repository
git clone https://github.com/FamtarT/speedrun-ranked-mod.git
cd speedrun-ranked-mod

# Build the mod
./gradlew build

# Build output
# build/libs/speedrun-ranked-mod-1.0.0.jar
```

### Clean Build

```bash
./gradlew clean build
```

### Generate IDE Project (IntelliJ IDEA)

```bash
./gradlew idea
```

Then open the project in IntelliJ IDEA.

### Generate IDE Project (Eclipse)

```bash
./gradlew eclipse
```

## Advanced Configuration

### Manual Configuration

Edit `~/.minecraft/config/speedrunranked/profile.json` to customize:

```json
{
  "currentRating": 1000,
  "currentRank": "Gold",
  "personalBestTime": 1200.5,
  "averageTime": 1500.0,
  "totalRuns": 10,
  "completedRuns": 7,
  "failedRuns": 2,
  "invalidRuns": 0,
  "abandonedRuns": 1
}
```

### Resetting Your Profile

1. Close Minecraft
2. Delete `~/.minecraft/config/speedrunranked/`
3. Restart Minecraft
4. A new profile will be created automatically

## Performance Tips

- **Lower render distance** to improve FPS during runs
- **Disable unnecessary mods** to reduce lag
- **Use 60+ FPS** for consistent gameplay
- **Allocate more RAM**: `-Xmx4G` in launcher settings

## Speedrunning Legality

This mod is designed to follow Minecraft speedrunning principles:

✅ No world generation modifications
✅ No x-ray or structure ESP
✅ No automated combat or movement
✅ No hidden information in Ranked mode
✅ Respects vanilla Minecraft mechanics

⚠️ **Before submitting runs to speedrun.com**, check the [legal-mods list](https://github.com/Minecraft-Java-Edition-Speedrunning/legal-mods)

## Getting Help

- 📖 [README.md](README.md) - Full feature documentation
- 🐛 [GitHub Issues](https://github.com/FamtarT/speedrun-ranked-mod/issues) - Report bugs
- 💬 [GitHub Discussions](https://github.com/FamtarT/speedrun-ranked-mod/discussions) - Ask questions

## Updating

### To Update to a New Version

1. Download the new JAR
2. Replace the old JAR in `~/.minecraft/mods/`
3. Restart Minecraft
4. Your profile and run history are preserved

## Uninstalling

1. Remove `speedrun-ranked-mod-1.0.0.jar` from `~/.minecraft/mods/`
2. Optionally delete config: `~/.minecraft/config/speedrunranked/`
3. Restart Minecraft

## Support

If you encounter issues:

1. Check this guide first
2. Search [GitHub Issues](https://github.com/FamtarT/speedrun-ranked-mod/issues)
3. Create a new issue with:
   - Your operating system
   - Java version (`java -version`)
   - Minecraft version
   - Error logs

---

**Enjoy speedrunning!** 🚀
