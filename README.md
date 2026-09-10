# Speedrun Ranked - MCSR Ranked Single-Player Mod

[![GitHub](https://img.shields.io/badge/GitHub-FamtarT-blue)](https://github.com/FamtarT/speedrun-ranked-mod)
[![Minecraft](https://img.shields.io/badge/Minecraft-1.16.1-green)](https://www.minecraft.net/)
[![Fabric](https://img.shields.io/badge/Fabric-Loader-orange)](https://fabricmc.net/)
[![License](https://img.shields.io/badge/License-MIT-yellow)](LICENSE)

## Overview

**Speedrun Ranked** is a comprehensive Minecraft 1.16.1 Fabric mod that recreates the competitive speedrunning experience of **MCSR Ranked** in single-player mode. Players can enjoy ranked runs, practice with curated seeds from GapCheck, and compete against themselves with a local ELO rating system.

## Features

### Core Gameplay
- ✅ **Ranked Mode**: Compete with curated seeds and track your rating
- ✅ **Practice Mode**: Practice with GapCheck seeds or random worlds
- ✅ **High-Precision Timer**: System clock-based timing with centisecond accuracy
- ✅ **Run Integrity Checks**: Prevent cheating with command detection and game mode validation
- ✅ **Local ELO System**: Track your rating and rank locally (Coal → Netherite)
- ✅ **Seed Management**: Multi-provider seed system (GapCheck, Local, Random)

### User Interface
- ✅ **Main Menu**: Start ranked runs, practice, view stats
- ✅ **Run Result Screen**: See your completion time and rating changes
- ✅ **Statistics Screen**: Track your performance metrics
- ✅ **Run History**: Review all completed runs
- ✅ **HUD Display**: Real-time timer, rank, and rating during runs

### Advanced Features
- ✅ **Placement System**: Complete 5 placement runs to establish your starting rating
- ✅ **Optional RNG Standardization**: Deterministic RNG for standardized gameplay
- ✅ **Split Tracking**: Track individual segment times
- ✅ **JSON Data Persistence**: All runs and stats saved locally
- ✅ **Configurable Settings**: Customize timer, seed sources, and integrity checks

## Installation

### Requirements
- **Minecraft Java Edition**: 1.16.1
- **Fabric Loader**: 0.13.3 or later
- **Java**: 8 or later

### Setup

1. **Download the mod JAR**
   ```bash
   git clone https://github.com/FamtarT/speedrun-ranked-mod.git
   cd speedrun-ranked-mod
   ./gradlew build
   ```

2. **Locate the built JAR**
   ```
   build/libs/speedrun-ranked-mod-1.0.0.jar
   ```

3. **Install into Minecraft**
   - Copy the JAR to your Minecraft mods folder:
     ```
     ~/.minecraft/mods/speedrun-ranked-mod-1.0.0.jar
     ```
   - (Windows: `%APPDATA%\.minecraft\mods`)
   - (macOS: `~/Library/Application Support/minecraft/mods`)
   - (Linux: `~/.minecraft/mods`)

4. **Launch Minecraft**
   - Use Fabric Loader 0.13.3+
   - Create a new world in 1.16.1
   - Press ESC and look for "Speedrun Ranked" options

## Usage

### Starting a Ranked Run

1. Create a new Minecraft world (1.16.1)
2. Press ESC to open pause menu
3. Select "Speedrun Ranked" from the menu
4. Click "Start Ranked Run"
5. Watch the 3-second countdown
6. Complete the speedrun to the Ender Dragon
7. View your result and rating change

### Practice Mode

- Select "Practice" from the main menu
- Choose between **Random Seeds** or **GapCheck Seeds**
- Play without rating changes
- Pause and reset freely

### Monitoring Your Progress

- **Statistics Screen**: View current rating, rank, personal best, and run history
- **Run History Screen**: Browse all completed runs with timestamps and results
- **In-Game HUD**: Monitor timer, rating, and rank during runs

## Configuration

Settings are stored in:
```
~/.minecraft/config/speedrunranked/
├── profile.json      # Player profile and rating
├── runs.json         # Run history
└── seeds-cache.json  # Cached seed data
```

### Customizable Options

- **Timer Duration**: Countdown timer length (default: 3 seconds)
- **Ranked RNG**: Enable/disable deterministic RNG standardization
- **Seed Source**: Prefer GapCheck, local cache, or random seeds
- **Integrity Checks**: Enable command detection, mode validation, etc.

## Architecture

### Project Structure

```
src/main/java/com/speedrunranked/
├── SpeedrunRankedMod.java        # Main entry point
├── run/                           # Run management
│   ├── RunManager.java
│   ├── RunState.java
│   └── SpeedrunRun.java
├── timer/                         # Timing system
│   └── SpeedrunTimer.java
├── rating/                        # ELO system
│   ├── RatingManager.java
│   ├── RatingCalculator.java
│   └── Rank.java
├── seed/                          # Seed providers
│   ├── SeedCache.java
│   ├── GapCheckSeedProvider.java
│   ├── LocalSeedProvider.java
│   └── RandomSeedProvider.java
├── integrity/                     # Run validation
│   ├── IntegrityManager.java
│   └── InvalidReason.java
├── data/                          # Persistence
│   ├── JsonDataManager.java
│   └── PlayerData.java
├── rng/                           # RNG standardization
│   ├── RankedRng.java
│   └── RngCategory.java
├── config/                        # Configuration
│   └── SpeedrunConfig.java
├── gui/                           # User interface
│   ├── RankedMainScreen.java
│   ├── RunResultScreen.java
│   ├── StatisticsScreen.java
│   ├── RunHistoryScreen.java
│   ├── PracticeScreen.java
│   └── SettingsScreen.java
├── hud/                           # HUD rendering
│   └── SpeedrunHud.java
├── mixin/                         # Game integration
│   ├── EnderDragonEntityMixin.java
│   ├── LivingEntityMixin.java
│   ├── GameModeChangeMixin.java
│   ├── ServerWorldMixin.java
│   └── ClientWorldMixin.java
├── client/                        # Client-side logic
│   ├── ClientEventHandler.java
│   └── ClientInitializer.java
└── split/                         # Split tracking
    └── SplitTimer.java
```

## Rating System

### Ranks

- 🟪 **Coal**: 0–599
- 🟦 **Iron**: 600–899
- 🟨 **Gold**: 900–1199
- 💚 **Emerald**: 1200–1499
- 💙 **Diamond**: 1500–1999
- 🟥 **Netherite**: 2000+

### Rating Calculation

```
Rating Change = K × (Performance Score - Expected Score)
```

- **K Factor**: 32 (adjustable)
- **Performance Score**: Based on time vs reference time
- **Expected Score**: Calculated from current rating

### Placement Matches

New players must complete **5 placement runs** to establish a starting rating.

## Run Integrity

The mod prevents cheating by detecting:

- ✅ Game mode changes
- ✅ Difficulty changes  
- ✅ Command usage (`/tp`, `/give`, `/gamemode`)
- ✅ Creative/Spectator mode
- ✅ Illegal teleports

**Invalid runs receive NO rating change.**

## GapCheck Integration

The mod can retrieve curated seeds from [GapCheck](https://gapcheck.gg/):

- Fetches seeds asynchronously (non-blocking)
- Caches seeds locally for offline play
- Respects GapCheck's rate limits and robots.txt
- Falls back to local/random seeds if GapCheck is unavailable

## Troubleshooting

### Mod won't load
- Ensure you have Fabric Loader 0.13.3+
- Check that Minecraft is set to 1.16.1
- Verify the JAR is in `.minecraft/mods/`

### Rating not changing
- Complete placement runs first (5 runs required)
- Check for integrity violations (invalid runs show "RUN INVALID")
- Ensure you're in Ranked mode, not Practice mode

### Timer not visible
- Press ESC to open menu and start a ranked run
- Timer appears on-screen during countdown and run

### Seeds not loading
- Check internet connection for GapCheck access
- Local seeds should always work as fallback
- Random seed mode is always available

## Important Notes

### Not Official MCSR Ranked

This mod is a **fan-made single-player recreation** inspired by MCSR Ranked. It is **NOT official** and your rating is stored locally only.

### Speedrunning Legality

This mod is designed to follow legitimate Minecraft speedrunning principles:
- No world generation modifications
- No hidden information in Ranked mode
- No gameplay automation or cheats
- Respects vanilla Minecraft mechanics

For speedrun.com submission, check the current [legal-mods list](https://github.com/Minecraft-Java-Edition-Speedrunning/legal-mods) before claiming compatibility.

## Development

### Building from Source

```bash
git clone https://github.com/FamtarT/speedrun-ranked-mod.git
cd speedrun-ranked-mod
./gradlew build
```

### Running Tests

```bash
./gradlew test
```

### Contributing

Contributions are welcome! Please:
1. Fork the repository
2. Create a feature branch
3. Submit a pull request

## License

MIT License - See [LICENSE](LICENSE) file

## Credits

- **MCSR Community**: For the original Ranked ruleset
- **GapCheck**: For providing curated seeds
- **Fabric Team**: For the amazing mod loader
- **Community Contributors**: For feedback and testing

## Links

- 🔗 [GitHub Repository](https://github.com/FamtarT/speedrun-ranked-mod)
- 🎮 [GapCheck](https://gapcheck.gg/)
- 📖 [Fabric Documentation](https://fabricmc.net/)
- ⚙️ [Legal Mods List](https://github.com/Minecraft-Java-Edition-Speedrunning/legal-mods)

---

**Enjoy your speedruns!** 🚀
