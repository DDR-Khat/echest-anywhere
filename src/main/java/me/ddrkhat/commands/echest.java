package me.ddrkhat.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;

import static net.minecraft.server.command.CommandManager.literal;

public class echest
{
    public static void init(CommandDispatcher<ServerCommandSource> dispatcher,
                            CommandRegistryAccess access,
                            CommandManager.RegistrationEnvironment env)
    {
        LiteralArgumentBuilder<ServerCommandSource> cmd = literal("echest")
                .requires(ServerCommandSource::isExecutedByPlayer)
                .executes(echest::run);
        dispatcher.register(cmd);
    }

    private static int run(CommandContext<ServerCommandSource> ctx) throws CommandSyntaxException
    {
        var player = ctx.getSource().getPlayerOrThrow();
        {
            player.openHandledScreen(new SimpleNamedScreenHandlerFactory((i, playerInventory, playerEntity) -> GenericContainerScreenHandler.createGeneric9x3(i, playerInventory, player.getEnderChestInventory()), Text.translatable("block.minecraft.ender_chest")));
            player.incrementStat(Stats.OPEN_ENDERCHEST);
            return 1;
        }
    }
}
