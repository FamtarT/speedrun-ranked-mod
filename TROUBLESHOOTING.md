# Troubleshooting Guide - Speedrun Ranked Mod

## Common Issues and Solutions

### Installation Issues

#### Issue: "Fabric Loader not found"

**Symptoms:**
- Minecraft launches but mods aren't loaded
- Error message mentions Fabric Loader

**Solutions:**
1. Reinstall Fabric Loader from https://fabricmc.net/
2. Select correct Minecraft version: **1.16.1**
3. Verify installation in Minecraft Launcher:
   - Installations tab
   - Should show "fabric-loader-0.13.3-1.16.1" or similar
4. Check Launcher Profiles → Minecraft Version is set to Fabric version

---

#### Issue: Mod JAR is in mods folder but doesn't load

**Symptoms:**
- File exists in `~/.minecraft/mods/`
- Mod doesn't appear in-game
- No error messages

**Solutions:**
1. Verify file name: `speedrun-ranked-mod-1.0.0.jar`
2. Check file is not corrupted (10+ MB)
3. Restart Minecraft completely
4. Try lowercase folder name: `~/.minecraft/mods/` (all lowercase)
5. Delete Minecraft cache:
   - `~/.minecraft/versions/fabric-loader-x.x.x-1.16.1/`
   - Reinstall Fabric Loader

---

#### Issue: Java version incompatibility

**Symptoms:**
- "Unsupported Java version"
- "ClassNotFoundException"
- Crash on startup

**Solutions:**
1. Check Java version:
   ```bash
   java -version
   ```
   Should output Java 8 or later

2. Update Java:
   - Windows/Mac: https://java.com/download/
   - Linux: `sudo apt install default-jre`

3. Set Minecraft to use correct Java:
   - Launcher → Installations → Edit
   - Java Executable → Browse to your JDK

---

### Gameplay Issues

#### Issue: Timer doesn't appear during runs

**Symptoms:**
- Run starts but no timer visible
- HUD is blank
- Only see normal Minecraft UI

**Solutions:**
1. Start a ranked run (not practice):
   - ESC → Speedrun Ranked → Start Ranked Run
2. Check HUD position:
   - Timer should appear top-left corner
3. Verify mod loaded:
   - Check logs for "[Speedrun Ranked] Mod initialized"
4. Try starting run again after restart

---

#### Issue: Rating not changing after completing runs

**Symptoms:**
- Run completes successfully
- Rating screen shows "+0 ELO"
- Rank unchanged

**Solutions:**
1. **Complete placement runs first:**
   - New profiles need 5 placement runs
   - Check: "Placement Complete: Starting Rating"

2. **Verify ranked mode:**
   - Make sure starting "Ranked Run", not "Practice"
   - Practice mode never changes rating

3. **Check for invalid runs:**
   - Look for "RUN INVALID" message
   - Check for integrity violations (commands, mode changes)

4. **Verify data was saved:**
   - Check `~/.minecraft/config/speedrunranked/profile.json`
   - Rating should update after completion

---

#### Issue: Ender Dragon defeat not detected

**Symptoms:**
- Defeated dragon but run doesn't complete
- Timer keeps running
- No result screen appears

**Solutions:**
1. Try manually resetting and restarting:
   - Press R (reset keybind)
   - Start new run

2. Check for mods conflict:
   - Remove other mods temporarily
   - Test with just Fabric + Speedrun Ranked

3. Verify dragon was actually defeated:
   - Game should show "The End" screen
   - Dragon death particles should appear

4. Report issue if persists:
   - Create GitHub issue with details

---

### Data and Configuration Issues

#### Issue: Profile.json is corrupted

**Symptoms:**
- Game crashes on startup
- "Malformed JSON" error
- Can't load profile

**Solutions:**
1. **Backup your data:**
   ```bash
   cp -r ~/.minecraft/config/speedrunranked ~/.minecraft/config/speedrunranked.backup
   ```

2. **Delete corrupted file:**
   ```bash
   rm ~/.minecraft/config/speedrunranked/profile.json
   ```

3. **Restart Minecraft:**
   - Mod will create new profile.json
   - You'll start fresh (rating reset to 0)

4. **Restore from backup if needed:**
   ```bash
   cp ~/.minecraft/config/speedrunranked.backup/profile.json ~/.minecraft/config/speedrunranked/
   ```

---

#### Issue: Run history not saving

**Symptoms:**
- Runs show as completed
- Runs don't appear in "Run History"
- runs.json is empty

**Solutions:**
1. Check file permissions:
   - `~/.minecraft/config/speedrunranked/` should be writable
   - Try: `chmod 755 ~/.minecraft/config/speedrunranked/`

2. Verify disk space:
   - Ensure drive has free space
   - run.json could be several MB

3. Check for file system errors:
   - Run disk check
   - Try on different drive

4. Reset data:
   - Delete `runs.json`
   - Mod will recreate it next run

---

### Seed and GapCheck Issues

#### Issue: GapCheck seeds not loading

**Symptoms:**
- Can't access GapCheck seeds in practice mode
- Always get random seeds instead
- No error message

**Solutions:**
1. **Check internet connection:**
   ```bash
   ping gapcheck.gg
   ```

2. **Verify firewall isn't blocking:**
   - Check Windows Defender Firewall
   - Disable VPN if using one

3. **Clear seed cache:**
   - Delete `~/.minecraft/config/speedrunranked/seeds-cache.json`
   - Restart Minecraft
   - Mod will re-fetch seeds

4. **Try offline mode:**
   - Random seeds always work
   - GapCheck will work when online

---

#### Issue: "No seeds available"

**Symptoms:**
- Can't start any run
- Error: "Failed to obtain seed"
- Both ranked and practice fail

**Solutions:**
1. **Verify local seeds exist:**
   - Check `~/.minecraft/config/speedrunranked/seeds-cache.json`
   - Should contain at least some seeds

2. **Reset seed cache:**
   ```bash
   rm ~/.minecraft/config/speedrunranked/seeds-cache.json
   ```
   - Mod will generate default seeds on restart

3. **Check disk space:**
   - Ensure drive has space for seed file

4. **Permissions issue:**
   - Verify write access to config folder

---

### Performance Issues

#### Issue: Game lags during speedruns

**Symptoms:**
- Low FPS
- Stuttering
- Timer sometimes jumps

**Solutions:**
1. **Reduce render distance:**
   - Options → Video Settings → Render Distance
   - Set to 10 or lower

2. **Lower graphics settings:**
   - Graphics: Fast
   - Particles: Minimum
   - Smooth Lighting: Off

3. **Allocate more RAM:**
   - Launcher → Installations → Edit
   - JVM Arguments: `-Xmx4G` (4GB)
   - Needs at least 4GB free RAM

4. **Disable mods temporarily:**
   - Remove other mods from `mods/` folder
   - Keep only Fabric + Speedrun Ranked
   - Test performance

5. **Close background apps:**
   - Close browsers, Discord, etc.
   - Free up system resources

---

#### Issue: Timer is inaccurate/jumps around

**Symptoms:**
- Timer doesn't advance smoothly
- Shows inconsistent times
- Resets randomly

**Solutions:**
1. **Check FPS:**
   - Aim for 60+ FPS
   - Lower graphics if needed

2. **Use system clock (default):**
   - Verify SpeedrunConfig has `USE_SYSTEM_CLOCK = true`
   - Don't use tick-based timing

3. **Close overlay apps:**
   - OBS, Discord, Nvidia overlay interfere
   - Disable during runs

4. **Restart Minecraft:**
   - Sometimes timer sync gets off
   - Full restart fixes it

---

### Crash Issues

#### Issue: Game crashes on startup

**Symptoms:**
- Minecraft launches then exits
- Crash report generated
- "See log for details"

**Solutions:**
1. **Check crash report:**
   - `~/.minecraft/crash-reports/latest.txt`
   - Look for error message

2. **Common causes:**
   - **Mod conflict**: Remove other mods, test
   - **Java issue**: Update to Java 11+
   - **Fabric version**: Use Fabric Loader 0.13.3+

3. **Debug steps:**
   ```bash
   # Remove mod and test
   mv ~/.minecraft/mods/speedrun-ranked-mod*.jar ~/
   
   # Try launching Minecraft
   # If works, reinstall mod
   mv ~/speedrun-ranked-mod*.jar ~/.minecraft/mods/
   ```

4. **Reset Minecraft:**
   - Backup saves: `cp -r ~/.minecraft/saves ~/.minecraft/saves.backup`
   - Delete: `~/.minecraft/versions/fabric-loader-*-1.16.1/`
   - Reinstall Fabric Loader

---

#### Issue: Crash when starting ranked run

**Symptoms:**
- Game runs fine normally
- Crashes when clicking "Start Ranked Run"
- Error mentions mixins or dragon

**Solutions:**
1. **Check mixin config:**
   - Verify `speedrun_ranked.mixins.json` is correct
   - Look for typos in class names

2. **Remove conflicting mods:**
   - Other dragon-related mods may conflict
   - Test with only Speedrun Ranked

3. **Rebuild mod:**
   ```bash
   ./gradlew clean build
   ```
   - Replace old JAR with new one

---

### Network Issues

#### Issue: Can't connect to GapCheck

**Symptoms:**
- Timeout error
- Connection refused
- "Unable to reach gapcheck.gg"

**Solutions:**
1. **Verify internet connection:**
   ```bash
   ping google.com
   ```

2. **Check GapCheck status:**
   - Visit https://gapcheck.gg/ in browser
   - If down, that's the issue (not mod)

3. **Check firewall:**
   - Windows: Check Windows Defender Firewall
   - Mac: System Preferences → Security & Privacy
   - Linux: Check iptables/ufw

4. **Disable VPN temporarily:**
   - Some VPNs block GapCheck
   - Try without VPN

5. **Use offline mode:**
   - Mod works fine with random seeds offline
   - GapCheck is optional enhancement

---

## Getting Help

### Before Reporting an Issue

1. ✅ Read this guide
2. ✅ Check [GitHub Issues](https://github.com/FamtarT/speedrun-ranked-mod/issues)
3. ✅ Check [Discussions](https://github.com/FamtarT/speedrun-ranked-mod/discussions)
4. ✅ Try the solutions above

### How to Report

1. **Create GitHub Issue** with:
   - Clear title
   - Detailed description
   - Steps to reproduce
   - Logs and screenshots
   - System info (OS, Java, Minecraft version)

2. **Include logs:**
   - `~/.minecraft/logs/latest.log`
   - `~/.minecraft/crash-reports/latest.txt`
   - Copy entire error message

3. **Example:**
   ```
   Title: Timer not appearing during runs
   
   Description: After starting a ranked run, the timer HUD doesn't appear.
   
   Steps:
   1. Create new world
   2. Click ESC
   3. Start Ranked Run
   4. Timer doesn't appear
   
   Logs: [paste log content]
   OS: Windows 10
   Java: 11.0.12
   Minecraft: 1.16.1
   Fabric: 0.13.3
   ```

---

## Still Having Issues?

💬 Ask in [Discussions](https://github.com/FamtarT/speedrun-ranked-mod/discussions)
🐛 Report in [Issues](https://github.com/FamtarT/speedrun-ranked-mod/issues)
📧 Contact via GitHub

---

**We're here to help!** 🚀
