package cn.nukkit.command.defaults;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.data.CommandParamType;
import cn.nukkit.command.data.CommandParameter;
import cn.nukkit.network.protocol.SetHudPacket;
import cn.nukkit.network.protocol.types.hub.HudElement;
import cn.nukkit.network.protocol.types.hub.HudVisibility;

public class HudCommand extends VanillaCommand {

    public HudCommand(String name) {
        super(name, "commands.hud.description", "%commands.hud.usage");
        this.setPermission("nukkit.command.hud");
        this.getCommandParameters().clear();
        this.addCommandParameters("default", new CommandParameter[]{
                CommandParameter.newType("player", false, CommandParamType.TARGET),
                CommandParameter.newEnum("visible", false, new String[]{"hide", "reset"}),
                CommandParameter.newEnum("hud_element", false, new String[]{"armor", "air_bubbles_bar", "crosshair", "food_bar", "health", "hotbar", "paper_doll", "tool_tips", "progress_bar", "touch_controls", "vehicle_health"})
        });
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        Player player = Server.getInstance().getPlayerExact(args[0]);
        if (player == null) {
            sender.sendMessage("Player + " + args[0] + " + not found");
            return true;
        }
        if (args.length < 3) {
            return false;
        }

        HudVisibility visibility;
        switch (args[1]) {
            case "hide":
                visibility = HudVisibility.HIDE;
                break;
            case "reset":
                visibility = HudVisibility.RESET;
                break;
            default:
                visibility = null;
                break;
        }

        HudElement element;
        switch (args[2]) {
            case "armor":
                element = HudElement.ARMOR;
                break;
            case "air_bubbles_bar":
                element = HudElement.AIR_BUBBLES_BAR;
                break;
            case "crosshair":
                element = HudElement.CROSSHAIR;
                break;
            case "food_bar":
                element = HudElement.FOOD_BAR;
                break;
            case "health":
                element = HudElement.HEALTH;
                break;
            case "hotbar":
                element = HudElement.HOTBAR;
                break;
            case "paper_doll":
                element = HudElement.PAPER_DOLL;
                break;
            case "tool_tips":
                element = HudElement.TOOL_TIPS;
                break;
            case "progress_bar":
                element = HudElement.PROGRESS_BAR;
                break;
            case "touch_controls":
                element = HudElement.TOUCH_CONTROLS;
                break;
            case "vehicle_health":
                element = HudElement.VEHICLE_HEALTH;
                break;
            case "effects_bar":
                element = HudElement.EFFECTS_BAR;
                break;
            case "item_text_popup":
                element = HudElement.ITEM_TEXT_POPUP;
                break;
            default:
                element = null;
        }

        if(visibility == null || element == null) {
            sender.sendMessage("Invalid visibility or element");
            return false;
        }

        SetHudPacket packet = new SetHudPacket();
        packet.elements.add(element);
        packet.visibility = visibility;
        player.dataPacket(packet);

        sender.sendMessage("HUD element " + element.name() + " is now " + visibility.name() + " for " + player.getName());

        return true;
    }
}
